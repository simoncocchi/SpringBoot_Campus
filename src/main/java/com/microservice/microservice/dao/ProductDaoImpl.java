package com.microservice.microservice.dao;

import com.microservice.microservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    public static List<Product> listproduits = new ArrayList<>();
    static {
        listproduits.add(new Product(1, new String("Ordinateur portable"), 350));
        listproduits.add(new Product(2, new String("Aspirateur Robot"), 500));
        listproduits.add(new Product(3, new String("Table de Ping Pong"), 750));
    }

    @Override
    public List<Product> findAll() {
        return listproduits;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
