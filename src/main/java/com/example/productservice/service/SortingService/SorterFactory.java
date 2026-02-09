package com.example.productservice.service.SortingService;

import com.example.productservice.dto.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(SortingCriteria sortingCriteria){
        return switch (sortingCriteria){
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowSorter();
            case PRICE_LOW_TO_HIGH -> new PricelowToHighSorter();
            case RELEVANCE -> null;
            case POPULARITY -> null;
            case null, default -> null;
        };

    }
}
