package com.example.product.service;

import com.example.product.mapper.ProductMapper;
import com.example.product.model.dto.ProductCreateRequest;
import com.example.product.model.dto.ProductDto;
import com.example.product.model.entity.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto addProduct(ProductCreateRequest productDto) {
        var product = Product.builder()
                .name(productDto.name())
                .description(productDto.description())
                .price(productDto.price())
                .createdAt(Calendar.getInstance().getTime())
                .build();
        var savedProduct = productRepository.save(product);
        log.info("Added product: {}", savedProduct);
        return productMapper.toDto(savedProduct);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    public ProductDto update(ProductDto productDto) {
        var product = productRepository.findById(productDto.id());
        BeanUtils.copyProperties(product , productDto , "id");
        return null;
    }
}
