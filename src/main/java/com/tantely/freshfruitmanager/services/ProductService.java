package com.tantely.freshfruitmanager.services;

import com.tantely.freshfruitmanager.dtos.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductResponse createProduct(String name, Double price, Integer stockQuantity, String category, String origin, MultipartFile file);
}
