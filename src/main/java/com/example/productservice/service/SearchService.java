package com.example.productservice.service;
import com.example.productservice.dto.search.FilterDto;
import com.example.productservice.dto.search.SortingCriteria;
import com.example.productservice.models.productModel;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.FilteringService.FilterFactory;
import com.example.productservice.service.SortingService.SorterFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SearchService {
    private ProductRepository productRepository;
    public SearchService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public Page<productModel> search(String query,
                                     List<FilterDto> filters,
                                     SortingCriteria sortingCriteria,
                                     int pageNumber,
                                     int pageSize){
        List<productModel> products = productRepository.findByTitle(query);
        for(FilterDto filterDto:filters){
            products= FilterFactory.getFiltersFromKey(filterDto.getKey())
                    .apply(products,filterDto.getValues());
        }
        products = SorterFactory.getSorterByCriteria(sortingCriteria).sort(products);
        List<productModel> ProductsOnPage = new ArrayList<>();
        for(int i =pageSize *(pageNumber-1); i<=(pageSize*pageNumber);++i){
            if(i<products.size()){
                ProductsOnPage.add(products.get(i));
            }
            else{
                break;
            }
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return new PageImpl<>(ProductsOnPage, pageable, products.size());


    }
    public Page<productModel> SimpleSearch(String query,
                                           int pageNumber,
                                           int pageSize,
                                           String sortingAttribute,
                                           Long categoryId){

        Page<productModel> products = productRepository.findAllByTitleAndCategory_Id(query, categoryId, PageRequest.of(pageNumber, pageSize, Sort.by(sortingAttribute).ascending()));
        return products;


    }


}
