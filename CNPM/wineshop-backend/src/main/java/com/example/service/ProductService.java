package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> filterProducts(String brand, Double alcohol, Double maxPrice) {
        return productRepository.filterProducts(brand, alcohol, maxPrice);
    }

    public Double getMinPrice() {
        return productRepository.findMinPrice();
    }

    public Double getMaxPrice() {
        return productRepository.findMaxPrice();
    }
}
