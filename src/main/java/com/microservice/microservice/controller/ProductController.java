package com.microservice.microservice.controller;

import com.microservice.microservice.dao.ProductDao;
import com.microservice.microservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Controller pour les produits, pour savoir qu'elle route améne a quoi
@RestController
public class ProductController {

    @Autowired
    private ProductDao ProductDao;

    @GetMapping(value = "produits")
    public List<Product> ProductsList(){
        return ProductDao.findAll();
    }

    //Produits/{id} Création de notre route
    @GetMapping(value = "produits/{id}")
    public Product DisplayProduct(@PathVariable int id){
        Product prodoct2 = new Product(id, new String("testProduit1"), 150);
        return prodoct2;
    }

}
