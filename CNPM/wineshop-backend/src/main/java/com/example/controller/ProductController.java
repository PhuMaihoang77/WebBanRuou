package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double alcohol,
            @RequestParam(required = false) Double maxPrice) {
//        System.out.println(">>> Giá max nhận được từ FE: " + maxPrice);
        List<Product> filtered = productService.filterProducts(brand, alcohol, maxPrice);
        return ResponseEntity.ok(filtered);
    }

    // API lấy min & max price cho frontend setting slider
    @GetMapping("/price-range")
    public ResponseEntity<Map<String, Double>> getPriceRange() {
        Map<String, Double> map = new HashMap<>();
        map.put("minPrice", productService.getMinPrice());
        map.put("maxPrice", productService.getMaxPrice());
        return ResponseEntity.ok(map);
    }
}
