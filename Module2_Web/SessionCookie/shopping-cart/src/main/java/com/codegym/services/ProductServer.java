package com.codegym.services;

import com.codegym.models.Product;

import java.util.List;

public interface ProductServer {
    List<Product> findAll();
    void save (Product product);
    void update (int id,Product product);
    void remove(int id);
    Product findByName (String name);
    Product findById(int id);
    Product see_product_details(int id);
}
