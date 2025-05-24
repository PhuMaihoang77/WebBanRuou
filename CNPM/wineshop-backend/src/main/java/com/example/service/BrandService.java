package com.example.service;

import com.example.dto.BrandWithCountDTO;
import com.example.model.Brand;
import com.example.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<BrandWithCountDTO> getBrandsWithProductCount() {
        return brandRepository.getBrandsWithProductCount();
    }
}
