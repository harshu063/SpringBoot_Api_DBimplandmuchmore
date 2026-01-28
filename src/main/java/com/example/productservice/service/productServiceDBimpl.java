package com.example.productservice.service;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.productModel;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DBimpl")
public class productServiceDBimpl implements productService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public productServiceDBimpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository=categoryRepository;
    }


    @Override
    public productModel createProduct(productModel product) {

       String categoryName = product.getCategory().getName();

        Optional<Category> category =
                categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;

        if(category.isEmpty()){
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            toBePutInProduct= categoryRepository.save(toSaveCategory);



        }else {
            toBePutInProduct =category.get();
        }
       product.setCategory(toBePutInProduct);

        productModel savedProduct = productRepository.save(product);
     return savedProduct;
    }

    @Override
    public List<productModel> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public productModel partialUpdateProduct(Long productId, productModel product) {
        product.setId(productId);
        Optional<productModel> productToUpdateOptional = productRepository.findById(productId);
       if(productToUpdateOptional.isEmpty()){
           throw new ProductNotFoundException("ProductNotFOund");
       }
       productModel productToUpdate = productToUpdateOptional.get();

        if(product.getDescription() !=null){
         productToUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getTitle()!=null){
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getImageURL()!=null){
            productToUpdate.setImageURL(product.getImageURL());

        }

        if(product.getCategory()!=null){
            String categoryName = product.getCategory().getName();

            Optional<Category> category =
                    categoryRepository.findByName(categoryName);
            Category toBePutInProduct = null;

            if(category.isEmpty()){
                Category toSaveCategory = new Category();
                toSaveCategory.setName(categoryName);
                toBePutInProduct= categoryRepository.save(toSaveCategory);



            }else {
                toBePutInProduct =category.get();
            }
            productToUpdate.setCategory(toBePutInProduct);
        }

        return productRepository.save(productToUpdate);
    }

    @Override
    public productModel getProductById(Long id) {
        return null;
    }
}
