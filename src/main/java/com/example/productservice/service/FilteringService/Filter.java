package com.example.productservice.service.FilteringService;

import com.example.productservice.models.productModel;

import java.util.List;

public interface Filter {
    List<productModel> apply(List<productModel> products, List<String> allowedvalues );
}
