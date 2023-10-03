package com.kuka.Wishlist.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class WishListRequestTest {

    WishListRequest classUnderTest = new WishListRequest();
    WishListRequest wishListRequest=new WishListRequest();

    //WishListRequest wishListRequest1=new WishListRequest();


    @Test
    public void testWishListRequest() {
        classUnderTest = prepareWishListRequest();
        wishListRequest.hashCode();
        Assertions.assertFalse(wishListRequest.equals(null));

        Assertions.assertEquals(1, classUnderTest.getSerialNo());
        Assertions.assertEquals(12, classUnderTest.getUserId());
        Assertions.assertEquals(1, classUnderTest.getQuantity());
        Assertions.assertEquals("abc", classUnderTest.getProductId());
    }

    @Test
    public void testWishListRequestEquals()
    {
        WishListRequest wishListRequest1=prepareWishListRequest();
        WishListRequest wishListRequest2=prepareWishListRequest();
        Assertions.assertTrue(wishListRequest1.equals(wishListRequest1));//local time
        wishListRequest2.setSerialNo(0);
        Assertions.assertFalse(wishListRequest1.equals(wishListRequest2));
        wishListRequest2.setQuantity(8);
        Assertions.assertFalse(wishListRequest1.equals(wishListRequest2));
        wishListRequest2.setProductId("nmn");
        Assertions.assertFalse(wishListRequest1.equals(wishListRequest2));
        wishListRequest2.setUserId(9);


        WishListRequest wishListRequest3=new WishListRequest(1, "abc",wishListRequest.getCreatedAt(),12,1);
    }

    private WishListRequest prepareWishListRequest() {
        WishListRequest wishListRequest = new WishListRequest();


        wishListRequest.setSerialNo(1);
        wishListRequest.setCreatedAt(LocalDateTime.now());
        wishListRequest.setUserId(12);
        wishListRequest.setQuantity(1);
        wishListRequest.setProductId("abc");

        return wishListRequest;
    }
}
