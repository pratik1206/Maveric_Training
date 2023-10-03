package com.kuka.plp.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

    private String productId;
    private String categoryId;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Timestamp createdAt;

}
