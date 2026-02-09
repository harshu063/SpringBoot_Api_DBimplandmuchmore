package com.example.productservice.repository;

import com.example.productservice.models.productModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<productModel, Long> {
    @Override
    productModel save (productModel p);

    @Override
    void delete(productModel entity);
    List<productModel> findAll();
    List<productModel> findByCategoryName(String categoryName);
    List<productModel> findByTitle (String title);
    List<productModel> findByCategory_Id(Long categoryId);
    Page<productModel> findAllByTitleAndCategory_Id(String title, Long categoryId, Pageable pageable);

    Optional<productModel> findById(Long id);
}

