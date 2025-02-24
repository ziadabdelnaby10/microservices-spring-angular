package com.example.order.service;

import com.example.order.mapper.OrderMapper;
import com.example.order.model.dto.OrderCreateRequest;
import com.example.order.model.dto.OrderDto;
import com.example.order.model.entity.Order;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDto placeOrder(OrderCreateRequest orderDto) {
        var order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderDto.price())
                .skuCode(orderDto.skuCode())
                .orderDate(LocalDate.now())
                .quantity(orderDto.quantity())
                .build();
        var savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }
}
