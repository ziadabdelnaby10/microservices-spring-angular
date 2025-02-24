package com.example.product.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public record ProductDto(
        String id,
        String name,
        String description,
        BigDecimal price,
        Date createdAt
) {
}
