package com.example.redisratelimiter.controller;


import com.example.redisratelimiter.service.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private  RateLimiterService rateLimiterService;

    @GetMapping("/limited")
    public ResponseEntity<String> limited(@RequestHeader(value= "X-Client-Id", required = false) String clientId){
        if(clientId == null || clientId.isBlank()){
            clientId="anonymous";
        }

        String key="rate_limit:"+clientId;
        if(rateLimiterService.isAllowed(key)){
            return ResponseEntity.ok("You are within the rate limit.");
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Rate limit exceeded. Please try again later.");
    }

}
