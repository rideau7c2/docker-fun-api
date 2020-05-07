package com.gitlab.rideau7c2.dockerfunapi.rest;

import com.gitlab.rideau7c2.dockerfunapi.mongo.Product;
import com.gitlab.rideau7c2.dockerfunapi.mongo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    Product add(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    List<Product> getList() {
        return productRepository.findAll();
    }
}