package com.motivationalq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.motivationalq.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
