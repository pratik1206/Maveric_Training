package com.kuka.Wishlist.service;

import com.kuka.Wishlist.Entity.WishlistItem;
import com.kuka.Wishlist.dao.IWishlistRepo;
import com.kuka.Wishlist.dto.DeleteResponse;
import com.kuka.Wishlist.dto.WishListRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListServiceImpl implements IWishListService {
    private static final Logger logger = LoggerFactory.getLogger(WishListServiceImpl.class);

    @Autowired
    private IWishlistRepo iWishlistRepo;


    /**
     * Adds an item to the user's wish list or updates the quantity if the item is already in the wish list.
     *
     * @param wishListRequest The request containing product and user information.
     * @return The updated wishListRequest.
     */
    @Override
    public WishListRequest addItemToWishList(WishListRequest wishListRequest) {

        WishlistItem wishlistItem = iWishlistRepo.findByProductId(wishListRequest.getProductId(), wishListRequest.getUserId());

        if (wishlistItem != null) {
            wishlistItem.setQuantity(wishlistItem.getQuantity() + 1);

        } else {
            wishlistItem = new WishlistItem();

            BeanUtils.copyProperties(wishListRequest, wishlistItem);
            wishlistItem.setQuantity(1);

        }
        wishlistItem = iWishlistRepo.saveAndFlush(wishlistItem);
        BeanUtils.copyProperties(wishlistItem, wishListRequest);
        return wishListRequest;
    }

    /**
     * Deletes an item from the user's wish list.
     *
     * @param productId The ID of the product to be deleted.
     * @param userId    The ID of the user's wish list to delete from.
     * @return A DeleteResponse indicating the result of the deletion.
     * @throws Exception If the item to be deleted is not found.
     */

    public DeleteResponse deleteItemFromWishList(String productId, int userId) throws Exception{

        WishlistItem wishlistItem = iWishlistRepo.findByProductId(productId, userId);
        System.out.println(wishlistItem.toString());
        if (wishlistItem != null && wishlistItem.getProductId() != null) {

            iWishlistRepo.delete(wishlistItem);
            DeleteResponse response = new DeleteResponse("Product deleted");

            return response;

        } else {

//            throw new RuntimeException("WishlistItem not found for Id");
            throw WishListItemNotFoundException.wishListItemNotFound(productId);
        }


    }

    /**
     * Retrieves a list of wish list items for a specific user.
     *
     * @param userId The ID of the user whose wish list items to retrieve.
     * @return A list of WishListRequest objects representing the user's wish list items.
     */

    public List<WishListRequest> getListOfWishListItem(int userId) {

        List<WishlistItem> wishlistItems=iWishlistRepo.getListOfWishListItems(userId);
        if (wishlistItems.isEmpty()){
            return new ArrayList<>();
        }

        return convertToListOfWishListRequest(wishlistItems);
    }


    /**
     * Converts a list of WishlistItem objects to a list of WishListRequest objects.
     *
     * @param wishlistItem The list of WishlistItem objects to convert.
     * @return A list of WishListRequest objects.
     */

    private  List<WishListRequest> convertToListOfWishListRequest(List<WishlistItem> wishlistItem){
        List<WishListRequest>  wishListRequests=new ArrayList<>();
        for (WishlistItem item:wishlistItem){
            wishListRequests.add(convertToWishListRequest(item));
        }

        return wishListRequests;

    }


    /**
     * Converts a WishlistItem object to a WishListRequest object.
     *
     * @param wishlistItem The WishlistItem object to convert.
     * @return A WishListRequest object.
     */

    private  WishListRequest convertToWishListRequest(WishlistItem wishlistItem){

        WishListRequest wishListRequest=new WishListRequest();
        BeanUtils.copyProperties(wishlistItem,wishListRequest);
        return wishListRequest;

    }
}




