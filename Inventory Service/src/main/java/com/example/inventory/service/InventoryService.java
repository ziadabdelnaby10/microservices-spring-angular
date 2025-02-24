package com.example.inventory.service;

import com.example.inventory.model.dto.InventoryCreateRequest;
import com.example.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Boolean isInStock(String skuCode , int quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(
                skuCode,
                quantity
        );
    }
}
