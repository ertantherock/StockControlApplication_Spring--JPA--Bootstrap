package com.example.sprinjpaproject2.repositories;

import com.example.sprinjpaproject2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}