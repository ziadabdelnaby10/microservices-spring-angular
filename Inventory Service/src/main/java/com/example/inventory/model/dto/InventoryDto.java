package com.example.inventory.model.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.inventory.model.entity.Inventory}
 */
@Data
public class InventoryDto implements Serializable {
    Long id;
    String skuCode;
    Integer quantity;
}