package com.food.orderservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> orderRequest) {

        Map<String, Object> paymentRequest = Map.of(
                "order_id", "ord_001",
                "customer_id", orderRequest.get("customer_id"),
                "amount", orderRequest.get("amount"),
                "payment_method", "credit_card"
        );

        Map paymentResponse = restTemplate.postForObject(
                "http://localhost:8080/api/payments",
                paymentRequest,
                Map.class
        );

        return Map.of(
                "order_id", "ord_001",
                "status", "CONFIRMED",
                "payment_response", paymentResponse
        );
    }
}
