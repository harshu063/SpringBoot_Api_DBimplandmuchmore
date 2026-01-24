package com.example.productservice.dto.fakeStore;

import com.example.productservice.models.productModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreGetbodyResponsedto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String Image;

    public productModel toProduct(){
        productModel product1 = new productModel();
        product1.setId(this.getId());
        product1.setCategoryName(this.getCategory());
        product1.setPrice(this.getPrice());
        product1.setDescription(this.getDescription());
        product1.setImageURL(this.getImage());
    return product1;
    }
}
