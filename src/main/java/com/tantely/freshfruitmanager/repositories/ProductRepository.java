package com.tantely.freshfruitmanager.repositories;

import com.tantely.freshfruitmanager.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByNameIgnoreCaseContainingAndPriceBetween(String searchName, Double priceMin, Double priceMax, Pageable pageable);

    Page<Product> findAllByPriceBetween(Double priceMin, Double priceMax, PageRequest pageRequest);

    Page<Product> findAllByNameIgnoreCaseContainingAndPriceLessThanEqual(String searchName, Double priceMax, PageRequest pageRequest);

    Page<Product> findAllByNameIgnoreCaseContainingAndPriceGreaterThanEqual(String searchName, Double priceMin, PageRequest pageRequest);

    Page<Product> findAllByNameIgnoreCaseContaining(String searchName, PageRequest pageRequest);

    Page<Product> findAllByPriceGreaterThanEqual(Double priceMin, PageRequest pageRequest);

    Page<Product> findAllByPriceLessThanEqual(Double priceMax, PageRequest pageRequest);
}
