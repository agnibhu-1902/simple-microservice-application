package com.example.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{userId}")
    public String getOrder(@PathVariable String userId) {
        String userResponse = restTemplate.getForObject("http://user-service/users/" + userId, String.class);
        return "Order placed for -> " + userResponse;
    }
}
