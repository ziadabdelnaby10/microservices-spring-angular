package com.example.order.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {

//    Logger log = LoggerFactory.getLogger(InventoryClient.class);

    @GetExchange("/api/inventory/instock")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    ResponseEntity<Boolean> isInStock(@RequestParam String skuCode, @RequestParam int quantity);

    default ResponseEntity<Boolean> fallbackMethod(String code, int quantity, Throwable throwable) {
        System.out.println("Cannot get inventory for SkuCode " + code + ", failure reason " + throwable.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }
}
