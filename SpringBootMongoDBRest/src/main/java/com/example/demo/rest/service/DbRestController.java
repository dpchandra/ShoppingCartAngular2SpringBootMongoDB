/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest.service;

import com.example.demo.rest.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dpurna
 */
@RestController
public class DbRestController {

    @Autowired
    MongoServiceHelper mongoServiceHelper;

    @RequestMapping("/api/products")
    public List<Product> getProducts() {
        return mongoServiceHelper.getProducts();
    }
}
