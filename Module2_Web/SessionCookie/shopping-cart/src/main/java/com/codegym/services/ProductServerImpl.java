package com.codegym.services;

import com.codegym.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServerImpl implements ProductServer {
    private static Map<Integer, Product> list;
    @Autowired
    private ProductServer productServer;

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return productServer.findById(id);
    }

    @Override
    public Product see_product_details(int id) {
        return null;
    }

    static {
        list = new HashMap<>();
        list.put(1, new Product(1, "Exciter", 50000000, 1234, "động cơ 5 hợp số , hệ số côn tay, yamaha"));
        list.put(2, new Product(2, "Sirius", 30000000, 4321, "động cơ 4 hợp số , hệ số côn tự động, yamaha"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(list.values());
    }


}
