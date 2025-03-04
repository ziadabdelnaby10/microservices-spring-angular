package com.example.inventory.service;

import com.example.inventory.mapper.InventoryMapper;
import com.example.inventory.model.dto.InventoryDto;
import com.example.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public Boolean isInStock(String skuCode, int quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(
                skuCode,
                quantity
        );
    }

    public List<InventoryDto> findAll() {
        return inventoryRepository.findAll().stream().map(inventoryMapper::toDto).toList();
    }
}
