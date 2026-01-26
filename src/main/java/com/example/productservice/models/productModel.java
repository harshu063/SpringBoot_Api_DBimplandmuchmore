package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class productModel extends BaseModel{

    private String title;
    private String description;
    private Double price;
    @ManyToOne
    private Category category;
    private String ImageURL;


}
