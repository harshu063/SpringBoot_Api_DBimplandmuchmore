package com.example.productservice.service;

import com.example.productservice.models.productModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface productService {

   productModel createProduct(productModel product);

   List<productModel> getAllProducts();

   productModel partialUpdateProduct(Long productId, productModel product);

   productModel getProductById(Long id);

//   productModel partialUpdateProduct(Long productId, productModel );
}
