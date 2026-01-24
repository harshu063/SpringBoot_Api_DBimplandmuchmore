package com.example.productservice.dto.products;

import com.example.productservice.models.productModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class getAllProductsResponseDto {

        private Long id;
        private String title;
        private String description;
        private Double price;
        private String CategoryName;
        private String ImageUrl;

    public static getAllProductsResponseDto from(productModel product){
        getAllProductsResponseDto getAllProductsResponseDto=new getAllProductsResponseDto();
        getAllProductsResponseDto.setId(product.getId());
        getAllProductsResponseDto.setDescription(product.getDescription());
        getAllProductsResponseDto.setPrice(product.getPrice());
        getAllProductsResponseDto.setImageUrl(product.getImageURL());
        getAllProductsResponseDto.setTitle(product.getTitle());
            return getAllProductsResponseDto;
    }

}
