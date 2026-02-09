package com.example.productservice.controllers;

import com.example.productservice.dto.products.GetProductDto;
import com.example.productservice.dto.search.FilterDto;
import com.example.productservice.dto.search.SearchResponseDto;
import com.example.productservice.dto.search.SortingCriteria;
import com.example.productservice.models.productModel;
import com.example.productservice.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;
    public SearchController(SearchService searchService){
        this.searchService=searchService;
    }

    @GetMapping
    public SearchResponseDto search(@RequestParam ("query")String query,
                                    @RequestParam ("filters")List<FilterDto> filters,
                                    @RequestParam ("sort")SortingCriteria sortingCriteria,
                                    @RequestParam("pageNumber") int pageNumber,
                                    @RequestParam("pageSize") int pageSize) {
        SearchResponseDto response = new SearchResponseDto();

       Page<productModel> productsPage =searchService.search(query, filters, sortingCriteria, pageNumber, pageSize);

       List<GetProductDto> getProductDtos = productsPage.getContent().stream().map(GetProductDto::from).collect(Collectors.toList());

       Pageable pageable = PageRequest.of(productsPage.getNumber(), productsPage.getSize());
       Page<GetProductDto> getProductDtoPage = new PageImpl<>(getProductDtos, pageable, productsPage.getTotalElements());

    response.setProductsPage(getProductDtoPage);
        return response;
    }

    @GetMapping("/byCategory")
    public SearchResponseDto SimpleSearch(@RequestParam ("category")String category,
                                          @RequestParam ("pageNumber") int pageNumber,
                                          @RequestParam ("pageSize") int pageSize,
                                            @RequestParam("sortingattribute") String sortingAttribute)
        {
            return null;

    }
}
