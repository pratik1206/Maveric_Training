package com.kuka.cart.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cart")
public class CartItem {

	@Id
	@GeneratedValue
	private Long cart_id;
	@Column(name="user_id")
	private int userId;
	@Column(name="product_id")
	private String productId;
	private int quantity;
	private BigDecimal price;
	private BigDecimal total_price;
	private LocalDateTime created_at;


}
