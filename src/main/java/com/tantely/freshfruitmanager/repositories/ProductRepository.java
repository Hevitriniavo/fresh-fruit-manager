package com.tantely.freshfruitmanager.repositories;

import com.tantely.freshfruitmanager.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
