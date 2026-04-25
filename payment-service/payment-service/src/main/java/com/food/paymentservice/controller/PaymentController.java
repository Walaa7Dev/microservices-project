package com.food.paymentservice.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping
    public Map<String, Object> processPayment(@RequestBody Map<String, Object> request) {
        return Map.of(
                "payment_id", "pay_001",
                "order_id", request.get("order_id"),
                "status", "COMPLETED",
                "transaction_id", "txn_123456"
        );
    }

    @GetMapping("/test")
    public Map<String, String> test() {
        return Map.of("message", "Payment Service is working!");
    }
}