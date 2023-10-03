package com.kuka.plp.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


//@Table(name = "product_data")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

//       @Id
//        @GeneratedValue
//        private Long product_id;


        @Column(name = "product_id")
        //@Column(name="category_id")
        @Id
        private String productId;
        private String categoryId;
        private String name;
        private String description;
        private double price;
        private int stockQuantity;
        private Timestamp createdAt;
        // Constructors, getters, setters



}

