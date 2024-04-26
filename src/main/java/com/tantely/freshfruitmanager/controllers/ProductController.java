package com.tantely.freshfruitmanager.controllers;

import com.tantely.freshfruitmanager.dtos.ProductResponse;
import com.tantely.freshfruitmanager.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
    @RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse createProduct(
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Integer stockQuantity,
            @RequestParam String category,
            @RequestParam String origin,
            @RequestParam MultipartFile file
    ) {
        return productService.createProduct(name, price, stockQuantity, category, origin, file);
    }
}
