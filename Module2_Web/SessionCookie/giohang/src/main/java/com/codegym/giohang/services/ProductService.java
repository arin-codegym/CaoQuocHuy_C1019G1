package com.codegym.giohang.services;

import com.codegym.giohang.models.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
