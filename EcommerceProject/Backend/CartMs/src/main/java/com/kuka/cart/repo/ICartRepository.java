package com.kuka.cart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuka.cart.entities.CartItem;

public interface ICartRepository extends JpaRepository<CartItem, Long> {

	CartItem findByProductId(String productId);

	List<CartItem> findByUserId(int userId);

	CartItem findByProductIdAndUserId(String productId, int userId);

	void deleteByProductId(String productId);

}
