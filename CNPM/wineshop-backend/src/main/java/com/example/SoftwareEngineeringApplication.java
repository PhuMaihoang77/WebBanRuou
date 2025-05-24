package com.example;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareEngineeringApplication implements CommandLineRunner {
    @Autowired
    ProductService productService;
    @Override
    public void run(String... args) throws Exception {
       for (Product p : productService.getAllProduct()){
           System.out.println(p);
       }
    }

    public static void main(String[] args) {
        SpringApplication.run(SoftwareEngineeringApplication.class, args);
    }

}
