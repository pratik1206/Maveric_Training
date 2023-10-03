package com.kuka.Wishlist.controller;

import com.kuka.Wishlist.dto.WishListRequest;
import com.kuka.Wishlist.service.IWishListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:54778")
public class WishlistController {

    private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);
    @Autowired
    private IWishListService wishListService;


    /**
     *
     * @param wishListRequest
     * @return The item which is added to wishlist
     */
    @PostMapping("/add")
    public ResponseEntity<WishListRequest> addItemToWishList(@RequestBody WishListRequest wishListRequest) {
        logger.debug("addItemToWishList {}", wishListRequest);
        return new ResponseEntity<>(wishListService.addItemToWishList(wishListRequest), HttpStatus.valueOf(200));

    }

    /**
     *
     * @param productId
     * @param userId
     * @return deleted Item
     */

    @DeleteMapping("/delete/{productId}/{userId}")
    public ResponseEntity<Object> deleteItemFromWishList(@PathVariable String productId, @PathVariable int userId) {
        try {
            return new ResponseEntity<>(wishListService.deleteItemFromWishList(productId, userId), HttpStatus.OK);
        } catch (Exception e) {
            ResponseEntity responseEntity = new ResponseEntity("Product not found to delete", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }


    }

    /**
     *
     * @param userId
     * @return list of product for perticular user
     */

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<WishListRequest>> getListOfWishListItem(@PathVariable int userId){

        return new ResponseEntity<>(wishListService.getListOfWishListItem( userId),HttpStatus.OK);
    }
}
