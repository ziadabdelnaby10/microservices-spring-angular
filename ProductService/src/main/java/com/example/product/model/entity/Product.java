package com.example.product.model.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "PRODUCT")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Date createdAt;
}
