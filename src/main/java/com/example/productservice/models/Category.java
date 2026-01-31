package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

//    @Column(nullable = false, name = "category_name", unique = true)
    @Column(nullable = false, unique = true, name = "category_name")
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<productModel> featuredProducts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<productModel> allProducts;
    private int countOfProducts;

}
