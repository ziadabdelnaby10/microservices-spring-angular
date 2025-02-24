package com.example.inventory.mapper;

import com.example.inventory.model.dto.InventoryCreateRequest;
import com.example.inventory.model.dto.InventoryDto;
import com.example.inventory.model.entity.Inventory;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);

    Inventory toEntity(InventoryCreateRequest inventoryCreateRequest);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryCreateRequest inventoryCreateRequest, @MappingTarget Inventory inventory);
}
