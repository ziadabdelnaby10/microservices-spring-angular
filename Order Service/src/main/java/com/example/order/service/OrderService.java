package com.example.order.service;

import com.example.order.client.InventoryClient;
import com.example.order.mapper.OrderMapper;
import com.example.order.model.dto.OrderCreateRequest;
import com.example.order.model.dto.OrderDto;
import com.example.order.model.entity.Order;
import com.example.order.model.event.OrderPlacedEvent;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public OrderDto placeOrder(OrderCreateRequest orderDto) {
        var isProductInStock = inventoryClient.isInStock(orderDto.skuCode(), orderDto.quantity()).getBody();

        if (Boolean.FALSE.equals(isProductInStock))
            throw new RuntimeException("Product with SkuCode " + orderDto.skuCode() + " is not in stock");

        var order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderDto.price())
                .skuCode(orderDto.skuCode())
                .orderDate(LocalDate.now())
                .quantity(orderDto.quantity())
                .build();
        var savedOrder = orderRepository.save(order);

        var orderEvent = new OrderPlacedEvent();
        orderEvent.setOrderNumber(order.getOrderNumber());
        orderEvent.setEmail(orderDto.userDetails().email());
        orderEvent.setFirstName(orderDto.userDetails().firstName());
        orderEvent.setLastName(orderDto.userDetails().lastName());

        log.info("Start - sending OrderPlacedEvent {} to Kafka topic , order-placed", orderEvent);
        kafkaTemplate.send("order-placed", orderEvent);
        log.info("End - sending OrderPlacedEvent {} to Kafka topic , order-placed", orderEvent);

        return orderMapper.toDto(savedOrder);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }
}
