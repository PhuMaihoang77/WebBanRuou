package com.example.controller;

import com.example.dto.BrandWithCountDTO;
import com.example.model.Brand;
import com.example.repository.BrandRepository;
import com.example.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin(origins = "http://localhost:8080") // Cho phép CORS nếu gọi từ frontend
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/getBrandsWithCount")
    public List<BrandWithCountDTO> getBrandsWithCount() {
        return brandService.getBrandsWithProductCount();
    }
}

