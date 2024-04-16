package com.example.UserService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.UserService.filters.JwtRequestFilter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/register")
                .permitAll();

        http.addFilterBefore(jwtRequestFilter,
                UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }

}
