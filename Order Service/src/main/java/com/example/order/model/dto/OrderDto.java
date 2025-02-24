package com.example.order.model.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.order.model.entity.Order}
 */
@Data
public class OrderDto implements Serializable {
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate orderDate;
}