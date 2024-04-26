package com.tantely.freshfruitmanager.services.impl;

import com.tantely.freshfruitmanager.dtos.ProductResponse;
import com.tantely.freshfruitmanager.exceptions.InternalServerException;
import com.tantely.freshfruitmanager.files.FileService;
import com.tantely.freshfruitmanager.mappers.ProductMapper;
import com.tantely.freshfruitmanager.repositories.ProductRepository;
import com.tantely.freshfruitmanager.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    private final FileService fileService;


    @Override
    public ProductResponse createProduct(String name, Double price, Integer stockQuantity, String category, String origin, MultipartFile file) {
        try {
            var url = fileService.saveFile(file);
            var product = productMapper.from(name, price, stockQuantity, category, origin, url);
            var savedProduct = productRepository.save(product);
            return productMapper.from(savedProduct);
        } catch (Exception ex) {
            throw new InternalServerException("Error creating product: " + ex.getMessage());
        }
    }
}
