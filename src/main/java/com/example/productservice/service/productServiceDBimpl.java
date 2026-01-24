package com.example.productservice.service;

import com.example.productservice.models.productModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DBimpl")
public class productServiceDBimpl implements productService{
    @Override
    public productModel createProduct(productModel product) {
        return null;
    }

    @Override
    public List<productModel> getAllProducts() {
        return List.of();
    }


    @Override
    public productModel partialUpdateProduct(Long productId, productModel product) {
        product.setId(productId);
        return product;
    }

    @Override
    public productModel getProductById(Long id) {
        return null;
    }
}
