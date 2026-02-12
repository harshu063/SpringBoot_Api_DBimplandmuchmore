package com.example.productservice.service.SortingService;

import com.example.productservice.dto.search.SortingCriteria;
import com.example.productservice.models.productModel;

import java.util.List;

public class PriceHighToLowSorter implements Sorter{

    @Override
    public List<productModel> sort(List<productModel> products, SortingCriteria criteria) {
        return List.of();
    }


}
