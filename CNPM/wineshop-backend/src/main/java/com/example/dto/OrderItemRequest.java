package com.example.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
    private Double price;
}
