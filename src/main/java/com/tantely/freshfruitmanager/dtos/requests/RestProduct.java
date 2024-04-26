package com.tantely.freshfruitmanager.dtos.requests;


public record RestProduct(
        String name,
        Double price,
        Integer stockQuantity,
        String category,
        String description,
        String url
) {
}
