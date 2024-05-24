package com.example.APIGateway.fillter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	public static final List<String> listApiAuthen=List.of(
			"/api/auth/signin",
			"/api/auth/signup",
			"/api/v1/books",
			"/api/v2/user"
			);
	public Predicate<ServerHttpRequest> isSecured= 
			request-> listApiAuthen
						.stream()
						.noneMatch(uri->request.getURI().getPath().contains(uri));
																				
}
