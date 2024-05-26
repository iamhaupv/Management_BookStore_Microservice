package com.example.CartService.controllers;

import java.net.ConnectException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.example.CartService.CartServiceApplication;
import com.example.CartService.dto.BookDTO;
import com.example.CartService.models.Cart;
import com.example.CartService.services.CartService;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/api/v4/")
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	private int attempts = 1;
	@Autowired
	private CartService cartService;
	@Autowired
	private RestTemplate restTemplate;
	private static final String CARTSERVICE = "cartService";

	// add book to cart
	@GetMapping("/cart/add/{id}")
//	@CachePut(value = "cart")
	@RateLimiter(name = CARTSERVICE, fallbackMethod = "rateLimiterFallback")
//	 @TimeLimiter(name=CARTSERVICE)
	public String addBookToCart(@PathVariable("id") Integer id) {
		logger.info("Loading call api order-service");
		logger.info("order method called:::" + attempts++);
		logger.info(LocalTime.now() + " Call processing finished = " + Thread.currentThread().getName());
		String url = "http://localhost:8083/api/v3/cart/add/" + id;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		logger.info("item service called:::");
		return "Addd book to cart successfully!";
	}

	public ResponseEntity<String> rateLimiterFallback(Exception e){
        return new ResponseEntity<String>("order service does not permit further calls", HttpStatus.TOO_MANY_REQUESTS);

    }

	

	// remove book from cart
	@GetMapping("/cart/remove/{id}")
//	@CacheEvict(value = "cart", allEntries = true)
	@Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 10000))
	public String removeBookFromCart(@PathVariable("id") Integer id) {
		logger.info("Loading call api order-service");
		String url = "http://localhost:8083/api/v3/cart/remove/" + id;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

		return "Remove book from cart successfully!";
	}
	@Recover
	public ResponseEntity<String> orderFallback(Exception e) {
		attempts = 0;
		return new ResponseEntity<String>("Item service is down", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	// view cart
	@GetMapping("/cart/view")
//	@Cacheable(value = "cart")
	public Collection<BookDTO> getView() throws URISyntaxException, ConnectException {
		logger.info("Loading call api order-service");
		try {
			String url = "http://localhost:8083/api/v3/cart/view";
			ResponseEntity<Collection<BookDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<Collection<BookDTO>>() {
					});
			Collection<BookDTO> products = responseEntity.getBody();
			return products;
		} catch (Exception ex) {
			logger.info("1" + ex.getMessage());
			if (ex instanceof ConnectException) {
				logger.info("2");
				throw new ConnectException(ex.getMessage());
			}
			if (ex instanceof ResourceAccessException) {
				logger.info("3");
				throw new ResourceAccessException(ex.getMessage());
			}
		}
		return null;
	}

	// clear cart
	@GetMapping("/cart/clear")
//	@CacheEvict(value = "cart", allEntries = true)
	public String clear() {
		String url = "http://localhost:8083/api/v3/cart/clear";
		ResponseEntity<BookDTO> responseEntity = restTemplate.getForEntity(url, BookDTO.class);

		return "Clear cart successfully";
	}

	@GetMapping("/cart/all")
	public List<Cart> all() {
		return cartService.all();
	}
}
