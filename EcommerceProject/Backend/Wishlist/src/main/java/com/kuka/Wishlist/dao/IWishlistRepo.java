package com.kuka.Wishlist.dao;

import com.kuka.Wishlist.Entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWishlistRepo extends JpaRepository<WishlistItem, Integer> {
    @Query("from WishlistItem where productId=:productId and userId=:userId")
    WishlistItem findByProductId(String productId, int userId);


    @Query("from WishlistItem where  userId=:userId")
    List<WishlistItem> getListOfWishListItems(int userId);


}
