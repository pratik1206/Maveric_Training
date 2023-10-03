package com.kuka.Wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListRequest {
    private int serialNo;


    private String productId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private int userId;
    private int quantity;

}
