package com.tantely.freshfruitmanager.controllers;

import com.tantely.freshfruitmanager.exceptions.InternalServerException;
import com.tantely.freshfruitmanager.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public Map<?, ?> createProduct(){
        throw new InternalServerException("OKkk");
    }
}
