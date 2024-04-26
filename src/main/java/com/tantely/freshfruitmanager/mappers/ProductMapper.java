package com.tantely.freshfruitmanager.mappers;

import com.tantely.freshfruitmanager.dtos.ProductResponse;
import com.tantely.freshfruitmanager.dtos.requests.RestProduct;
import com.tantely.freshfruitmanager.entities.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductMapper {

    public Product from(RestProduct restProduct, String url) {
        return Product.builder()
                .name(restProduct.name())
                .price(restProduct.price())
                .origin(restProduct.origin())
                .stockQuantity(restProduct.stockQuantity())
                .category(restProduct.category())
                .url(url)
                .addedDate(LocalDateTime.now())
                .build();
    }

    public ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getCategory(),
                product.getAddedDate(),
                product.getOrigin(),
                product.getUrl()
        );
    }

    public Product from(String name, Double price, Integer stockQuantity, String category, String origin, String url) {
        return Product.builder()
                .name(name)
                .price(price)
                .origin(origin)
                .stockQuantity(stockQuantity)
                .category(category)
                .url(url)
                .addedDate(LocalDateTime.now())
                .build();
    }
}
