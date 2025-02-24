package com.example.order.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record OrderCreateRequest(
        @NotNull(message = "SkuCode cannot be null")
        @NotBlank(message = "SkuCode cannot be empty")
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}
