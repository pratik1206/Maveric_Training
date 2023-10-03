package com.kuka.Wishlist.exception;

import com.kuka.Wishlist.service.WishListItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalServiceExceptionHandler {
    @ExceptionHandler(WishListItemNotFoundException.class)
    public ResponseEntity<String> handleWishListItemNotFoundException(WishListItemNotFoundException ex) {
        log.warn("Item not found exception: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
