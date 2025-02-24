package com.example.order.controller;

import com.example.order.model.dto.OrderCreateRequest;
import com.example.order.model.dto.OrderDto;
import com.example.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> create(@RequestBody @Valid OrderCreateRequest order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.placeOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
