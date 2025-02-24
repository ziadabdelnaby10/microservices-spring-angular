package com.example.order.mapper;

import com.example.order.model.dto.OrderDto;
import com.example.order.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}
