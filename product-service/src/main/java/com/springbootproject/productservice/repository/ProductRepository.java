package com.springbootproject.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springbootproject.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
