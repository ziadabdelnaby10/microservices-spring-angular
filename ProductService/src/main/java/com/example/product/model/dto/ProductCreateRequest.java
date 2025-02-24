package com.example.product.model.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateRequest(
        @NotBlank(message = "Please Provide a name for the product")
        @NotNull(message = "Name Cannot Be Null Ya Ba4a")
        String name,
        String description,
        BigDecimal price
) {

}
