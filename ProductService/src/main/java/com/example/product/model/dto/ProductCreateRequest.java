package com.example.product.model.dto;

import java.math.BigDecimal;

public record ProductCreateRequest(
        String name,
        String description,
        BigDecimal price
) {

}
