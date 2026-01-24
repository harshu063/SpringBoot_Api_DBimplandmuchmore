package com.example.productservice.dto.products;

import com.example.productservice.models.productModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductRequestdto {
    private String title;
    private String description;
    private Double price;
    private String CategoryName;


    public productModel toproductModel(){
        productModel productModel = new productModel();
        productModel.setTitle(this.title);
        productModel.setDescription(this.description);
        productModel.setPrice(this.price);
        productModel.setCategoryName(this.CategoryName);
        return productModel;
    }
}
