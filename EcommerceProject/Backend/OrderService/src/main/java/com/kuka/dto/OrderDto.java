package com.kuka.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private int orderId;
    private int userId;
    private LocalDateTime order_date;
    private float totalAmount;
    private String status;
}
