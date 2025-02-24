package com.example.inventory.model.dto;

import com.example.inventory.model.entity.Inventory;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

/**
 * DTO for {@link Inventory}
 */
public record InventoryCreateRequest(
        @NotNull(message = "skuCode Cannot be null")
        @NotEmpty(message = "skuCode Cannot be empty")
        String skuCode,
        @Digits(integer = 4, fraction = 0)
        @Positive
        Integer quantity
) implements Serializable {}