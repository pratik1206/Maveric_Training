package com.kuka.Wishlist.Service;

import com.kuka.Wishlist.Entity.WishlistItem;
import com.kuka.Wishlist.dao.IWishlistRepo;
import com.kuka.Wishlist.dto.DeleteResponse;
import com.kuka.Wishlist.dto.WishListRequest;
import com.kuka.Wishlist.service.WishListServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WishListServiceImplTest {

    public WishListServiceImpl classUnderTest=new WishListServiceImpl();

    @Mock
    private IWishlistRepo iWishlistRepo;

    @BeforeEach
    public void setUp()
    {

        ReflectionTestUtils.setField(classUnderTest, "iWishlistRepo",iWishlistRepo);
    }
    @Test
    public void addItemToWishListSuccess()
    {
        //if case
        int userId=12;
        String productId="abc";
        WishListRequest wishListRequest =PrepareWishListRequest();
        WishlistItem addItem = PrepareWishListItem();
        when(iWishlistRepo.findByProductId(productId,userId)).thenReturn(addItem);
        when(iWishlistRepo.saveAndFlush(addItem)).thenReturn(addItem);
        WishListRequest wishListedItem=classUnderTest.addItemToWishList(wishListRequest);/*--null  to pass*/

        assertEquals("abc",wishListedItem.getProductId());
        assertEquals(12, wishListedItem.getUserId());

    }








    @Test
    public void deleteItemFromWishList()throws Exception
    {
        //if case
        int userId=12;
        String productId="abc";

        WishlistItem Item = PrepareWishListItem();
        DeleteResponse deleteResponse=new DeleteResponse();
        when(iWishlistRepo.findByProductId(productId,userId)).thenReturn(Item);
        DeleteResponse delete=classUnderTest.deleteItemFromWishList(productId,userId);

        assertEquals("abc",Item.getProductId());
        assertEquals(12, Item.getUserId());


    }

    @Test
    public void deleteItemFromWishListElse()throws Exception
    {

        int userId=12;
        String productId="abc";
        when(iWishlistRepo.findByProductId(productId,userId)).thenReturn(null);
        //classUnderTest.deleteItemFromWishList(productId,userId);
        Assertions.assertThrows(RuntimeException.class,()->classUnderTest.deleteItemFromWishList(productId,userId));


    }

    private WishlistItem PrepareWishListItem() {
        WishlistItem wishListItem = new WishlistItem();


        wishListItem.setSerialNo(1);
        wishListItem.setCreatedAt(LocalDateTime.now());
        wishListItem.setUserId(12);
        wishListItem.setQuantity(1);
        wishListItem.setProductId("abc");

        return wishListItem;
    }


    private WishListRequest PrepareWishListRequest() {
        WishListRequest wishListRequest = new WishListRequest();


        wishListRequest.setSerialNo(1);
        wishListRequest.setCreatedAt(LocalDateTime.now());
        wishListRequest.setUserId(12);
        wishListRequest.setQuantity(1);
        wishListRequest.setProductId("abc");

        return wishListRequest;
    }


    //else case

    @Test
    public void addItemToWishListFailure()
    {
        //if case
        int userId=12;
        String productId="abc";
        WishListRequest wishListRequest =PrepareWishListRequest();
        WishlistItem addItem = PrepareWishListItem();
        when(iWishlistRepo.findByProductId(productId,userId)).thenReturn(null);
        when(iWishlistRepo.saveAndFlush(Mockito.any())).thenReturn(addItem);
        WishListRequest wishListedItem=classUnderTest.addItemToWishList(wishListRequest);


    }



    @Test
    public void testGetListOfWishListItem_WithValidUserId() {
        // Arrange
        int userId = 1;
        WishlistItem wishlistItem1 = new WishlistItem();
        wishlistItem1.setSerialNo(1);
        wishlistItem1.setProductId("product1");

        WishlistItem wishlistItem2 = new WishlistItem();
        wishlistItem2.setSerialNo(2);
        wishlistItem2.setProductId("product2");

        List<WishlistItem> wishlistItems = new ArrayList<>();
        wishlistItems.add(wishlistItem1);
        wishlistItems.add(wishlistItem2);

        when(iWishlistRepo.getListOfWishListItems(anyInt())).thenReturn(wishlistItems);

        // Act
        List<WishListRequest> result = classUnderTest.getListOfWishListItem(userId);

        // Assert
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getSerialNo());
        assertEquals("product1", result.get(0).getProductId());
        assertEquals(2, result.get(1).getSerialNo());
        assertEquals("product2", result.get(1).getProductId());
    }

    @Test
    public void testGetListOfWishListItem_WithEmptyWishlist() {

        int userId = 1;
        // Mock an empty wishlist
        when(iWishlistRepo.getListOfWishListItems(anyInt())).thenReturn(new ArrayList<>());
        List<WishListRequest> result = classUnderTest.getListOfWishListItem(userId);

        // Assert
        assertEquals(0, result.size());
    }



}
