package com.example.sprinjpaproject2.services;

import com.example.sprinjpaproject2.entities.Product;
import com.example.sprinjpaproject2.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> allProduct(){

        return productRepository.findAll();
    }

    public boolean productDelete(String stPid){
        try {

            long pid = Long.parseLong(stPid);
            boolean status = productRepository.existsById(pid);
            if (status){
                productRepository.deleteById(pid);

                return true;

            }
        }catch (Exception ex){

        }


        return false;
    }
}
