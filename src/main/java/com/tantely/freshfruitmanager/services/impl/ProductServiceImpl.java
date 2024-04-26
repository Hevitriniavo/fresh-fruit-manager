package com.tantely.freshfruitmanager.services.impl;

import com.tantely.freshfruitmanager.dtos.Paginate;
import com.tantely.freshfruitmanager.dtos.ProductResponse;
import com.tantely.freshfruitmanager.entities.Product;
import com.tantely.freshfruitmanager.exceptions.InternalServerException;
import com.tantely.freshfruitmanager.exceptions.NotFoundException;
import com.tantely.freshfruitmanager.files.FileService;
import com.tantely.freshfruitmanager.mappers.ProductMapper;
import com.tantely.freshfruitmanager.repositories.ProductRepository;
import com.tantely.freshfruitmanager.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    private final FileService fileService;


    @Override
    public ProductResponse createProduct(String name, Double price, Integer stockQuantity, String category, String description, MultipartFile file) {
        try {
            var url = fileService.saveFile(file);
            var product = productMapper.from(name, price, stockQuantity, category, description, url);
            var savedProduct = productRepository.save(product);
            return productMapper.from(savedProduct);
        } catch (Exception ex) {
            throw new InternalServerException("Error creating product: " + ex.getMessage());
        }
    }

    @Override
    public Paginate<ProductResponse> findAllProducts(Double priceMin, Double priceMax, String searchName, Integer currentPage, Integer pageSize) {
        try {
            var pageRequest = PageRequest.of(currentPage, pageSize);
            Page<Product> productPage;

            if (searchName != null && !searchName.isEmpty()) {
                if (priceMin != null && priceMax != null) {
                    productPage = productRepository.findAllByNameIgnoreCaseContainingAndPriceBetween(searchName, priceMin, priceMax, pageRequest);
                } else if (priceMin == null && priceMax == null) {
                    productPage = productRepository.findAllByNameIgnoreCaseContaining(searchName, pageRequest);
                } else if (priceMin == null) {
                    productPage = productRepository.findAllByNameIgnoreCaseContainingAndPriceLessThanEqual(searchName, priceMax, pageRequest);
                } else {
                    productPage = productRepository.findAllByNameIgnoreCaseContainingAndPriceGreaterThanEqual(searchName, priceMin, pageRequest);
                }
            } else {
                if (priceMin != null && priceMax != null) {
                    productPage = productRepository.findAllByPriceBetween(priceMin, priceMax, pageRequest);
                } else {
                    productPage = productRepository.findAll(pageRequest);
                }
            }

            var productResponses = productPage.getContent().stream()
                    .map(productMapper::from)
                    .collect(Collectors.toList());

            return new Paginate<>(productPage.getTotalPages(), productPage.hasNext() ? productPage.nextPageable().getPageNumber() : null, productPage.hasPrevious() ? productPage.previousPageable().getPageNumber() : null, productResponses);
        } catch (Exception ex) {
            throw new InternalServerException("Error fetching products: " + ex.getMessage());
        }
    }

    @Override
    public ProductResponse findProductById(Long productId) {
        var foundProduct = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product ID: " + productId + " not found"));
        return productMapper.from(foundProduct);
    }

}
