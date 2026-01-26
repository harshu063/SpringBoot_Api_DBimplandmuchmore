package com.example.productservice.service;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.dto.fakeStore.fakeStorebodyRequestdto;
import com.example.productservice.dto.fakeStore.fakeStoreGetbodyResponsedto;
import com.example.productservice.models.productModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class productServicefakestoreimpl implements productService{
        private RestTemplate restTemplate;

        public productServicefakestoreimpl(RestTemplate restTemplate){
            this.restTemplate=restTemplate;
        }
    @Override
    public productModel createProduct(productModel productModel) {
            fakeStorebodyRequestdto fakeStorebodyRequestdto = new fakeStorebodyRequestdto();

            fakeStorebodyRequestdto.setCategory(productModel.getCategory().getName());
            fakeStorebodyRequestdto.setTitle(productModel.getTitle());
            fakeStorebodyRequestdto.setPrice(productModel.getPrice());
            fakeStorebodyRequestdto.setImage(productModel.getImageURL());
            fakeStorebodyRequestdto.setDescription(productModel.getDescription());



           fakeStoreGetbodyResponsedto response = restTemplate.postForObject(
                    "https://fakestoreapi.com/products",
                    fakeStorebodyRequestdto,
                   fakeStoreGetbodyResponsedto.class

            );
        return response.toProduct();
    }

    @Override
    public List<productModel> getAllProducts() {
            throw new RuntimeException("kjdkwkd wekjnewkjw");
//           fakeStoreGetbodyResponsedto[] response= restTemplate.getForObject(
//                    "https://fakestoreapi.com/products",
//                    fakeStoreGetbodyResponsedto[].class
//            );
//           List<fakeStoreGetbodyResponsedto> responsedtoList = Stream.of(response).toList();
//           List<productModel> products= new ArrayList<>();
//           for(fakeStoreGetbodyResponsedto fakeStoreGetbodyResponsedto: responsedtoList){
//               products.add(fakeStoreGetbodyResponsedto.toProduct());
//           }
//           return products;
    }

    @Override
    public productModel partialUpdateProduct(Long productId, productModel product) {

        return null;
    }
    @Override
    public productModel getProductById(Long id) {

        fakeStoreGetbodyResponsedto response =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products/" + id,
                        fakeStoreGetbodyResponsedto.class
                );

        if (response == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return response.toProduct();
    }

}
