package com.example.JWTService.controller;

import com.example.JWTService.authen.UserPrincipal;
import com.example.JWTService.entity.Token;
import com.example.JWTService.entity.User;
import com.example.JWTService.service.TokenService;
import com.example.JWTService.service.UserService;
import com.example.JWTService.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private int attempts=1;
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TokenService tokenService;

//    @PostMapping("/register")
//    public User register(@RequestBody User user){
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//
//        return userService.createUser(user);
//    }
//    public ResponseEntity<?> register(@RequestBody User user) {
//        if (userService.usernameExists(user.getUsername())) {
//            return ResponseEntity.badRequest().body("Username already exists");
//        }
//
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
    @PostMapping("/register")
    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 10000))
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.usernameExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // Mã hóa mật khẩu
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        logger.info("order method called:::"+ attempts++);
        // Thêm người dùng vào service user
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8082/api/v2/user", user, String.class);
        logger.info("item service called:::");
        // Kiểm tra phản hồi từ service user
        if (response.getStatusCode() == HttpStatus.OK) {
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
        }
    }
    @Recover
    public ResponseEntity<String> orderFallback(Exception e){
        attempts=0;
        return new ResponseEntity<String>("Item service is down", HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userService.findByUsername(user.getUsername());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }


    @GetMapping("/hello")
//    @PreAuthorize("hasAnyAuthority('USER_READ')")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }




//    Object principal = SecurityContextHolder
//            .getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//        UserPrincipal userPrincipal = (UserPrincipal) principal;
//    }

}
