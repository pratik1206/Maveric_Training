package com.kuka.cart.service;

import java.util.List;

import com.kuka.cart.dto.CartItemDto;
import com.kuka.cart.entities.CartItem;

public interface ICartService {

	public CartItemDto addToCart(CartItemDto cartDto);

	public List<CartItemDto> getAllCarts();

	public List<CartItemDto> findCartItemsByUserId(int userId);

	public CartItemDto mapToDto(CartItem cartItem);

	public void deleteProductByCartId(Long cartId);

}
