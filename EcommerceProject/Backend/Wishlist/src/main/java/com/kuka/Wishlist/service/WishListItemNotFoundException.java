package com.kuka.Wishlist.service;

public class WishListItemNotFoundException extends RuntimeException {

    public WishListItemNotFoundException(String message) {
        super(message);
    }

    public static WishListItemNotFoundException wishListItemNotFound(String productId) {
        return new WishListItemNotFoundException("Product with ID " + productId + " not found");
    }


}
