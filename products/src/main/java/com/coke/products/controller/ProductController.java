package com.coke.products.controller;

import com.coke.products.entity.Product;
import com.coke.products.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired

    private ProductService productService;

   @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PostMapping("/addList")
    public List<Product> addProducts(@RequestBody List<Product> product){
        return productService.addProductList(product);
    }

    @GetMapping("/list")
    public List<Product> getProductList(){
       return productService.getProducts();
    }

    @GetMapping("/prodById/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer id){
        return productService.getProduct(id);
    }

    @GetMapping("/{name}")
    public Product getProductById(@PathVariable(value = "name") String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProd(@PathVariable Integer id){
       return productService.deleteById(id);
    }





}
