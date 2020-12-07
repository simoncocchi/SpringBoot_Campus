package com.microservice.microservice.dao;

import com.microservice.microservice.model.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findAll();

    public Product findById(int id);

    public Product save(Product product);

}
