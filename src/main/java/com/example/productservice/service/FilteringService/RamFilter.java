package com.example.productservice.service.FilteringService;

import com.example.productservice.models.productModel;

import java.util.List;

public class RamFilter implements Filter {
    @Override
    public List<productModel> apply(List<productModel> products, List<String> allowedvalues) {
        return List.of();
    }
}
