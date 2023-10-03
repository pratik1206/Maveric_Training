package com.kuka.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "user_id",nullable = false)
    private int userId;
    private LocalDateTime order_date;
   // @Column(nullable = false,precision = 10,scale = 2)
    @Column(nullable = false)
    private float totalAmount;
    // Set the default value for status to "Pending"
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'Pending'")
    private String status;
}
