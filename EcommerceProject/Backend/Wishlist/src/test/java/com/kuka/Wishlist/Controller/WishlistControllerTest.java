package com.kuka.Wishlist.Controller;

import com.kuka.Wishlist.controller.WishlistController;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WishlistControllerTest {
    WishlistController classUnderTest = new WishlistController();
    @Mock
    private WishListServiceImpl wishListServiceimpl;

    @Mock
    private IWishlistRepo iWishlistRepo;



    @BeforeEach
    public void setUp() {

        ReflectionTestUtils.setField(classUnderTest, "wishListService", wishListServiceimpl);

    }

    @Test
    public void addItemToWishListSuccess() {
        WishListRequest wishListRequest = PrepareWishListRequest();
        WishListRequest addedItem = PrepareWishListRequest();
        when(wishListServiceimpl.addItemToWishList(wishListRequest)).thenReturn(addedItem);

        ResponseEntity<WishListRequest> response = classUnderTest.addItemToWishList(wishListRequest);
        Assertions.assertTrue(response.getBody().getQuantity() == 1);

    }



@Test
    public void deleteItemFromWishListSuccess()throws Exception
    {
          String productId="abc";
          int userId=1;
        DeleteResponse deleteResponse=new DeleteResponse();
          when(wishListServiceimpl.deleteItemFromWishList(productId,userId)).thenReturn(deleteResponse);
        ResponseEntity<Object> response = classUnderTest.deleteItemFromWishList(productId,userId);


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




    @Test
    public void testGetListOfWishListItem() {
        int userId = 1; // Replace with your test user ID
        List<WishListRequest> expectedResult = new ArrayList<>();
        // Initialize the expected result with expected data

        when(wishListServiceimpl.getListOfWishListItem(userId)).thenReturn(expectedResult);

        ResponseEntity<List<WishListRequest>> responseEntity = classUnderTest.getListOfWishListItem(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResult, responseEntity.getBody());
    }



}
