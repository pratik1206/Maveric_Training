package com.kuka.Wishlist.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishlist_items ")

public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_no")
    private Integer serialNo;
    @Column(name = "product_id")

    private String productId;
    @CreationTimestamp
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "userId")

    private int userId;
    @Column(name = "quantity")
    private int quantity;


}
