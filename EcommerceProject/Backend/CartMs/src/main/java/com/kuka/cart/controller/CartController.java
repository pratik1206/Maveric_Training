package com.kuka.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuka.cart.dto.CartItemDto;
import com.kuka.cart.entities.CartItem;
import com.kuka.cart.service.ICartService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/cartservice")
public class CartController {

	@Autowired
	private ICartService cartService;

	/**
	 * 
	 * @param cartItemDto
	 * @return
	 */

	@PostMapping("/add")
	public ResponseEntity<CartItemDto> addToCart(@RequestBody CartItemDto cartItemDto) {
		CartItemDto addedCartItem = cartService.addToCart(cartItemDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedCartItem);
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */

	@GetMapping("/byUserId/{userId}")
	public ResponseEntity<List<CartItemDto>> getCartsByUserId(@PathVariable int userId) {
		List<CartItemDto> cartItems = cartService.findCartItemsByUserId(userId);

		if (cartItems.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(cartItems);
	}

	/**
	 * 
	 * @return
	 */

	@GetMapping("/all")
	public ResponseEntity<List<CartItemDto>> getAllCarts() {
		List<CartItemDto> cartItems = cartService.getAllCarts();
		if (cartItems.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
//		 List<CartItemDto> cartItemDtos = cartService.convertToDtos(cartItems);
		return ResponseEntity.ok(cartItems);
	}

	/**
	 * 
	 * @param productId
	 * @return
	 */

	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<Boolean> removeProductByCartId(@PathVariable Long cartId) {
		cartService.deleteProductByCartId(cartId);
		return ResponseEntity.ok(true);
	}

}
