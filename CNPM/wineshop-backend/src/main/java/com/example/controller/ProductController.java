package com.example.controller;

import com.example.model.Brand;
import com.example.model.Product;
import com.example.service.BrandService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    // Endpoint để lấy tất cả sản phẩm
    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

}