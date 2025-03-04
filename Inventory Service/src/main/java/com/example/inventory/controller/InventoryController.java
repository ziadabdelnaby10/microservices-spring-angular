package com.example.inventory.controller;

import com.example.inventory.model.dto.InventoryCreateRequest;
import com.example.inventory.model.dto.InventoryDto;
import com.example.inventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/instock")
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode ,@RequestParam int quantity) {
        return ResponseEntity.ok(inventoryService.isInStock(skuCode , quantity));
    }

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventory() {
        return ResponseEntity.ok(inventoryService.findAll());
    }
}
