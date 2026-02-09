package com.example.productservice.service.FilteringService;

public class FilterFactory {
    public static Filter getFiltersFromKey(String Key){

        return switch (Key){
            case "brand" -> new BrandFIlter();
            case "ram" -> new RamFilter();
            case null , default -> null;
        };
    }
}
