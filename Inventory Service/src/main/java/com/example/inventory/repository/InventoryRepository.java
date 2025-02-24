package com.example.inventory.repository;

import com.example.inventory.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query("select (count(i) > 0) from INVENTORIES i where i.skuCode = ?1 and i.quantity >= ?2")
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}