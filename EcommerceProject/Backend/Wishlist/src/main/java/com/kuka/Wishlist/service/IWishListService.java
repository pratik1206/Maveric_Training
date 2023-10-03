package com.kuka.Wishlist.service;

import com.kuka.Wishlist.dto.DeleteResponse;
import com.kuka.Wishlist.dto.WishListRequest;

import java.util.List;

public interface IWishListService {
    WishListRequest addItemToWishList(WishListRequest wishListRequest);
    DeleteResponse deleteItemFromWishList(String productId, int userId)throws Exception;

    List<WishListRequest> getListOfWishListItem(int userId);




}

