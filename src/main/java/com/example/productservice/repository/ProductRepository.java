package com.example.productservice.repository;

import com.example.productservice.models.productModel;
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

    Optional<productModel> findById(Long id);
}

