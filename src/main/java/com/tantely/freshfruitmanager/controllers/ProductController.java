package com.tantely.freshfruitmanager.controllers;

import com.tantely.freshfruitmanager.dtos.Paginate;
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
            @RequestParam String description,
            @RequestParam MultipartFile file
    ) {
        return productService.createProduct(name, price, stockQuantity, category, description, file);
    }


    @GetMapping
    public Paginate<ProductResponse> getAllProducts(
            @RequestParam(required = false) Double priceMin,
            @RequestParam(required = false) Double priceMax,
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false , defaultValue = "0") Integer currentPage,
            @RequestParam(required = false, defaultValue = "10") Integer pageNumber
    ) {
        return productService.findAllProducts(priceMin, priceMax, searchName, currentPage, pageNumber);
    }


    @GetMapping("/{productId}")
    public ProductResponse getProductById(@PathVariable Long productId){
        return productService.findProductById(productId);
    }
}
