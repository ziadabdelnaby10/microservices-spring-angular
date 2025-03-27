package com.example.order.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderCreateRequest(
        @NotNull(message = "SkuCode cannot be null")
        @NotBlank(message = "SkuCode cannot be empty")
        String skuCode,
        BigDecimal price,
        Integer quantity,
        UserDetails userDetails
) {
}
