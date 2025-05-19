package com.example.repository;

import com.example.dto.BrandWithCountDTO;
import com.example.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    @Query("SELECT new com.example.dto.BrandWithCountDTO(b.name, COUNT(p)) " +
            "FROM Brand b LEFT JOIN Product p ON p.brand = b AND p.isDeleted = false " +
            "WHERE b.isDeleted = false " +
            "GROUP BY b.name")
    List<BrandWithCountDTO> getBrandsWithProductCount();
}
