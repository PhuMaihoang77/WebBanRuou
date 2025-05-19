package com.example.service;

import com.example.model.Brand;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
