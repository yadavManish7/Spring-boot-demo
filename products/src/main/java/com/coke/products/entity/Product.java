package com.coke.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")  // if not specified,JPA will create table with class name
public class Product {
        @Id
        @GeneratedValue
        @Column(name = "product_id")  //To change name is DB table
        private  int id;
        @Column(name = "product_name")
        private String name;
        private int quantity;
        private double price;

}
