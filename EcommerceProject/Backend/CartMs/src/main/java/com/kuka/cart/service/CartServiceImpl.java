package com.kuka.cart.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuka.cart.dto.CartItemDto;
import com.kuka.cart.entities.CartItem;
import com.kuka.cart.repo.ICartRepository;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartRepository cartRepository;

	@Override
	public CartItemDto addToCart(CartItemDto cartDto) {

		int userId = cartDto.getUserId();
		String productId = cartDto.getProductId();
		int quantity = cartDto.getQuantity();
		BigDecimal price = cartDto.getPrice();

		CartItem existingCartItem = cartRepository.findByProductIdAndUserId(productId, userId);
		BigDecimal newTotalPrice = BigDecimal.ZERO;
		if (existingCartItem != null) {
			if (existingCartItem.getQuantity() < cartDto.getQuantity()) {
				newTotalPrice = existingCartItem.getTotal_price().add(price);
			} else if (existingCartItem.getQuantity() > cartDto.getQuantity()) {
				newTotalPrice = existingCartItem.getTotal_price().subtract(price);
			}
			existingCartItem.setQuantity(quantity);
			existingCartItem.setPrice(price);
			existingCartItem.setTotal_price(newTotalPrice);
			existingCartItem.setCreated_at(LocalDateTime.now());

			return mapToDto(cartRepository.save(existingCartItem));

		} else {
			CartItem cartItem = new CartItem();

			BigDecimal totalPriceByQuantity = cartDto.getPrice().multiply(BigDecimal.valueOf(cartDto.getQuantity()));

			cartItem.setUserId(cartDto.getUserId());
			cartItem.setProductId(cartDto.getProductId());
			cartItem.setQuantity(cartDto.getQuantity());
			cartItem.setPrice(cartDto.getPrice());
			cartItem.setTotal_price(totalPriceByQuantity);
			cartItem.setCreated_at(LocalDateTime.now());
			return mapToDto(cartRepository.save(cartItem));
		}

	}

	@Override
	public List<CartItemDto> findCartItemsByUserId(int userId) {
		List<CartItemDto> cartItemDto = new ArrayList<>();
		List<CartItem> cartItems = cartRepository.findByUserId(userId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItemDto cartItemDto1 = new CartItemDto();
			BeanUtils.copyProperties(cartItems.get(i), cartItemDto1);

			cartItemDto.add(cartItemDto1);
		}
//		 cartRepository.findByUserId(userId);
		return cartItemDto;
	}

	@Override
	public List<CartItemDto> getAllCarts() {
		List<CartItemDto> cartItemDto = new ArrayList<>();
		List<CartItem> cartItems = cartRepository.findAll();
		for (int i = 0; i < cartItems.size(); i++) {
			CartItemDto cartItemDto1 = new CartItemDto();
			BeanUtils.copyProperties(cartItems.get(i), cartItemDto1);

			cartItemDto.add(cartItemDto1);
		}

		// BeanUtils.copyProperties(cartRepository.findAll(), cartItemDto);

		return cartItemDto;
	}

	@Override
	public void deleteProductByCartId(Long cartId) {
		cartRepository.deleteById(cartId);
	}

	public CartItemDto mapToDto(CartItem cartItem) {
		CartItemDto cartItemDto = new CartItemDto();
		cartItemDto.setUserId(cartItem.getUserId());
		cartItemDto.setProductId(cartItem.getProductId());
		cartItemDto.setQuantity(cartItem.getQuantity());
		cartItemDto.setPrice(cartItem.getPrice());
		cartItemDto.setTotal_price(cartItem.getTotal_price());
		cartItemDto.setCreated_at(cartItem.getCreated_at());
		return cartItemDto;
	}

}
