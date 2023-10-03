package com.kuka.cart.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

	private Long cart_id;
	private int userId;
	private String productId;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal total_price;
	private LocalDateTime created_at;
	

}
