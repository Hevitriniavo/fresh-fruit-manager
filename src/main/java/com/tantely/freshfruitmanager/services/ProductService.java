package com.tantely.freshfruitmanager.services;

import com.tantely.freshfruitmanager.dtos.Paginate;
import com.tantely.freshfruitmanager.dtos.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductResponse createProduct(String name, Double price, Integer stockQuantity, String category, String description, MultipartFile file);

    Paginate<ProductResponse> findAllProducts(Double priceMin, Double maxValue, String searchName, Integer currentPage, Integer pageNumber);

    ProductResponse findProductById(Long productId);

    ProductResponse deleteProductById(Long productId);

    ProductResponse updateProduct(Long productId, String name, Double price, Integer stockQuantity, String category, String description, MultipartFile file);
}
