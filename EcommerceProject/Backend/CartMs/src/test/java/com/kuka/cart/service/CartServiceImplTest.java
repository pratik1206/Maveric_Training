package com.kuka.cart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kuka.cart.dto.CartItemDto;
import com.kuka.cart.entities.CartItem;
import com.kuka.cart.repo.ICartRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {
    @Autowired
    private CartServiceImpl cartServiceImpl;

    @MockBean
    private ICartRepository iCartRepository;

    /**
     * Method under test: {@link CartServiceImpl#addToCart(CartItemDto)}
     */
//    @Test
//  //  @Disabled("TODO: Complete this test")
//    void testAddToCart() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "com.kuka.cart.dto.CartItemDto.getQuantity()" is null
//        //       at com.kuka.cart.service.CartServiceImpl.addToCart(CartServiceImpl.java:27)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        cartServiceImpl.addToCart(new CartItemDto());
//    }

    /**
     * Method under test: {@link CartServiceImpl#addToCart(CartItemDto)}
     */
    @Test
    void testAddToCart2() {
        CartItem cartItem = new CartItem();
        cartItem.setCart_id(1L);
        cartItem.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
        cartItem.setPrice(BigDecimal.valueOf(1L));
        cartItem.setProductId("42");
        cartItem.setQuantity(1);
        BigDecimal total_price = BigDecimal.valueOf(1L);
        cartItem.setTotal_price(total_price);
        cartItem.setUserId(1);

        CartItem cartItem2 = new CartItem();
        cartItem2.setCart_id(1L);
        cartItem2.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
        cartItem2.setPrice(BigDecimal.valueOf(1L));
        cartItem2.setProductId("42");
        cartItem2.setQuantity(1);
        cartItem2.setTotal_price(BigDecimal.valueOf(1L));
        cartItem2.setUserId(1);
        when(iCartRepository.save(Mockito.<CartItem>any())).thenReturn(cartItem2);
        when(iCartRepository.findByProductIdAndUserId(Mockito.<String>any(), anyInt())).thenReturn(cartItem);

        CartItemDto cartDto = new CartItemDto();
        cartDto.setQuantity(1);
        CartItemDto actualAddToCartResult = cartServiceImpl.addToCart(cartDto);
        assertEquals(1, actualAddToCartResult.getUserId());
        BigDecimal expectedTotal_price = total_price.ONE;
        BigDecimal total_price2 = actualAddToCartResult.getTotal_price();
        assertSame(expectedTotal_price, total_price2);
        assertEquals(1, actualAddToCartResult.getQuantity().intValue());
        assertEquals("42", actualAddToCartResult.getProductId());
        assertEquals("00:00", actualAddToCartResult.getCreated_at().toLocalTime().toString());
        assertSame(total_price2, actualAddToCartResult.getPrice());
        assertEquals("1", total_price2.toString());
        verify(iCartRepository).findByProductIdAndUserId(Mockito.<String>any(), anyInt());
        verify(iCartRepository).save(Mockito.<CartItem>any());
    }

    /**
     * Method under test: {@link CartServiceImpl#addToCart(CartItemDto)}
     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testAddToCart3() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException: Cannot read field "intCompact" because "augend" is null
//        //       at java.base/java.math.BigDecimal.add(BigDecimal.java:1382)
//        //       at com.kuka.cart.service.CartServiceImpl.addToCart(CartServiceImpl.java:34)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        CartItem cartItem = mock(CartItem.class);
//        when(cartItem.getQuantity()).thenReturn(0);
//        when(cartItem.getTotal_price()).thenReturn(BigDecimal.valueOf(1L));
//        doNothing().when(cartItem).setCart_id(Mockito.<Long>any());
//        doNothing().when(cartItem).setCreated_at(Mockito.<LocalDateTime>any());
//        doNothing().when(cartItem).setPrice(Mockito.<BigDecimal>any());
//        doNothing().when(cartItem).setProductId(Mockito.<String>any());
//        doNothing().when(cartItem).setQuantity(anyInt());
//        doNothing().when(cartItem).setTotal_price(Mockito.<BigDecimal>any());
//        doNothing().when(cartItem).setUserId(anyInt());
//        cartItem.setCart_id(1L);
//        cartItem.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
//        cartItem.setPrice(BigDecimal.valueOf(1L));
//        cartItem.setProductId("42");
//        cartItem.setQuantity(1);
//        cartItem.setTotal_price(BigDecimal.valueOf(1L));
//        cartItem.setUserId(1);
//
//        CartItem cartItem2 = new CartItem();
//        cartItem2.setCart_id(1L);
//        cartItem2.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
//        cartItem2.setPrice(BigDecimal.valueOf(1L));
//        cartItem2.setProductId("42");
//        cartItem2.setQuantity(1);
//        cartItem2.setTotal_price(BigDecimal.valueOf(1L));
//        cartItem2.setUserId(1);
//        when(iCartRepository.save(Mockito.<CartItem>any())).thenReturn(cartItem2);
//        when(iCartRepository.findByProductIdAndUserId(Mockito.<String>any(), anyInt())).thenReturn(cartItem);
//
//        CartItemDto cartDto = new CartItemDto();
//        cartDto.setQuantity(1);
//        cartServiceImpl.addToCart(cartDto);
//    }

    /**
     * Method under test: {@link CartServiceImpl#findCartItemsByUserId(int)}
     */
    @Test
    void testFindCartItemsByUserId() {
        when(iCartRepository.findByUserId(anyInt())).thenReturn(new ArrayList<>());
        assertTrue(cartServiceImpl.findCartItemsByUserId(1).isEmpty());
        verify(iCartRepository).findByUserId(anyInt());
    }

    /**
     * Method under test: {@link CartServiceImpl#findCartItemsByUserId(int)}
     */
    @Test
    void testFindCartItemsByUserId2() {
        CartItem cartItem = new CartItem();
        cartItem.setCart_id(1L);
        cartItem.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
        cartItem.setPrice(BigDecimal.valueOf(1L));
        cartItem.setProductId("42");
        cartItem.setQuantity(1);
        cartItem.setTotal_price(BigDecimal.valueOf(1L));
        cartItem.setUserId(1);

        ArrayList<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);
        when(iCartRepository.findByUserId(anyInt())).thenReturn(cartItemList);
        assertEquals(1, cartServiceImpl.findCartItemsByUserId(1).size());
        verify(iCartRepository).findByUserId(anyInt());
    }

    /**
     * Method under test: {@link CartServiceImpl#getAllCarts()}
     */
    @Test
    void testGetAllCarts() {
        when(iCartRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(cartServiceImpl.getAllCarts().isEmpty());
        verify(iCartRepository).findAll();
    }

    /**
     * Method under test: {@link CartServiceImpl#getAllCarts()}
     */
    @Test
    void testGetAllCarts2() {
        CartItem cartItem = new CartItem();
        cartItem.setCart_id(1L);
        cartItem.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
        cartItem.setPrice(BigDecimal.valueOf(1L));
        cartItem.setProductId("42");
        cartItem.setQuantity(1);
        cartItem.setTotal_price(BigDecimal.valueOf(1L));
        cartItem.setUserId(1);

        ArrayList<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);
        when(iCartRepository.findAll()).thenReturn(cartItemList);
        assertEquals(1, cartServiceImpl.getAllCarts().size());
        verify(iCartRepository).findAll();
    }

    /**
     * Method under test: {@link CartServiceImpl#deleteProductByCartId(Long)}
     */
    @Test
    void testDeleteProductByCartId() {
        doNothing().when(iCartRepository).deleteById(Mockito.<Long>any());
        cartServiceImpl.deleteProductByCartId(1L);
        verify(iCartRepository).deleteById(Mockito.<Long>any());
        assertTrue(cartServiceImpl.getAllCarts().isEmpty());
    }

    /**
     * Method under test: {@link CartServiceImpl#mapToDto(CartItem)}
     */
    @Test
    void testMapToDto() {
        CartItem cartItem = new CartItem();
        cartItem.setCart_id(1L);
        cartItem.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
        cartItem.setPrice(BigDecimal.valueOf(1L));
        cartItem.setProductId("42");
        cartItem.setQuantity(1);
        BigDecimal total_price = BigDecimal.valueOf(1L);
        cartItem.setTotal_price(total_price);
        cartItem.setUserId(1);
        CartItemDto actualMapToDtoResult = cartServiceImpl.mapToDto(cartItem);
        assertEquals(1, actualMapToDtoResult.getUserId());
        BigDecimal expectedTotal_price = total_price.ONE;
        BigDecimal total_price2 = actualMapToDtoResult.getTotal_price();
        assertSame(expectedTotal_price, total_price2);
        assertEquals(1, actualMapToDtoResult.getQuantity().intValue());
        assertEquals("42", actualMapToDtoResult.getProductId());
        assertEquals("00:00", actualMapToDtoResult.getCreated_at().toLocalTime().toString());
        assertSame(total_price2, actualMapToDtoResult.getPrice());
        assertEquals("1", total_price2.toString());
    }

    /**
     * Method under test: {@link CartServiceImpl#mapToDto(CartItem)}
     */
    @Test
    void testMapToDto2() {
        CartItem cartItem = mock(CartItem.class);
        when(cartItem.getQuantity()).thenReturn(1);
        when(cartItem.getUserId()).thenReturn(1);
        when(cartItem.getProductId()).thenReturn("42");
        when(cartItem.getPrice()).thenReturn(BigDecimal.valueOf(1L));
        when(cartItem.getTotal_price()).thenReturn(BigDecimal.valueOf(1L));
        when(cartItem.getCreated_at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        doNothing().when(cartItem).setCart_id(Mockito.<Long>any());
        doNothing().when(cartItem).setCreated_at(Mockito.<LocalDateTime>any());
        doNothing().when(cartItem).setPrice(Mockito.<BigDecimal>any());
        doNothing().when(cartItem).setProductId(Mockito.<String>any());
        doNothing().when(cartItem).setQuantity(anyInt());
        doNothing().when(cartItem).setTotal_price(Mockito.<BigDecimal>any());
        doNothing().when(cartItem).setUserId(anyInt());
        cartItem.setCart_id(1L);
        cartItem.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
        cartItem.setPrice(BigDecimal.valueOf(1L));
        cartItem.setProductId("42");
        cartItem.setQuantity(1);
        BigDecimal total_price = BigDecimal.valueOf(1L);
        cartItem.setTotal_price(total_price);
        cartItem.setUserId(1);
        CartItemDto actualMapToDtoResult = cartServiceImpl.mapToDto(cartItem);
        assertEquals(1, actualMapToDtoResult.getUserId());
        BigDecimal expectedTotal_price = total_price.ONE;
        BigDecimal total_price2 = actualMapToDtoResult.getTotal_price();
        assertSame(expectedTotal_price, total_price2);
        assertEquals(1, actualMapToDtoResult.getQuantity().intValue());
        assertEquals("42", actualMapToDtoResult.getProductId());
        assertEquals("00:00", actualMapToDtoResult.getCreated_at().toLocalTime().toString());
        assertSame(total_price2, actualMapToDtoResult.getPrice());
        assertEquals("1", total_price2.toString());
        verify(cartItem).getQuantity();
        verify(cartItem).getUserId();
        verify(cartItem).getProductId();
        verify(cartItem).getPrice();
        verify(cartItem).getTotal_price();
        verify(cartItem).getCreated_at();
        verify(cartItem).setCart_id(Mockito.<Long>any());
        verify(cartItem).setCreated_at(Mockito.<LocalDateTime>any());
        verify(cartItem).setPrice(Mockito.<BigDecimal>any());
        verify(cartItem).setProductId(Mockito.<String>any());
        verify(cartItem).setQuantity(anyInt());
        verify(cartItem).setTotal_price(Mockito.<BigDecimal>any());
        verify(cartItem).setUserId(anyInt());
    }
}

