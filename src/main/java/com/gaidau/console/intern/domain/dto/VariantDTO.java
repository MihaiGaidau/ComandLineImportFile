package com.gaidau.console.intern.domain.dto;

public record VariantDTO(
        String id,
        String title,
        String sku,
        String barcode,
        Double price,
        Double compareAtPrice,
        InventoryItemDto inventoryItem
) {
}