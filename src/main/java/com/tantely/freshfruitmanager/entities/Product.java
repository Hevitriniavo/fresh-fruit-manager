package com.tantely.freshfruitmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer stockQuantity;

    private LocalDateTime addedDate;

    private String category;

    private String origin;

    private String url;

    @OneToMany(mappedBy = "product")
    private List<Comment> comments  = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems = new ArrayList<>();

}
