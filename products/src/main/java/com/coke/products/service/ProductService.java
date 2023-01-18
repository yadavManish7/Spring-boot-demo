package com.coke.products.service;

import com.coke.products.entity.Product;
import com.coke.products.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> addProductList(List<Product> products){
        return productRepo.saveAll(products);
    }

    public List<Product> getProducts(){
        List<Product> prodList=productRepo.findAll();
        return prodList;
    }

    public Product getProduct(int id){
        Product product = productRepo.findById(id).orElse(null);
        return  product;
    }
    public Product getProductByName(String name){
        Product product = productRepo.findByName(name);
        return  product;
    }

    public String deleteById(int id){
        productRepo.deleteById(id);
        return "product removed " + id;
    }

    public Product updateProduct(Product product){
        Product prod = productRepo.findById(product.getId()).orElse(null);
        prod.setName(product.getName());
        prod.setQuantity(product.getQuantity());
        prod.setPrice(product.getPrice());
        return productRepo.save(prod);
    }


}
