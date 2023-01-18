package com.coke.products.repository;

import com.coke.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByName(String name);

    //If you are not using spring boot framework, database connection code goes here!

}
