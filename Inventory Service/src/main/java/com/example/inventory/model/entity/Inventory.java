package com.example.inventory.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "INVENTORIES")
@Table
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;

    public Inventory(String skuCode, Integer quantity) {
        this.skuCode = skuCode;
        this.quantity = quantity;
    }
}
