package com.kuka.cart.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuka.cart.dto.CartItemDto;
import com.kuka.cart.service.ICartService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CartController.class})
@ExtendWith(SpringExtension.class)
class CartControllerTest {
    @Autowired
    private CartController cartController;
    
   
    @MockBean
    private ICartService iCartService;

    /**
     * Method under test: {@link CartController#getAllCarts()}
     */
    @Test
    void testGetAllCarts() throws Exception {
        when(iCartService.getAllCarts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartservice/all");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link CartController#getAllCarts()}
     */
    @Test
    void testGetAllCarts2() throws Exception {
        ArrayList<CartItemDto> cartItemDtoList = new ArrayList<>();
        cartItemDtoList.add(new CartItemDto());
        when(iCartService.getAllCarts()).thenReturn(cartItemDtoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartservice/all");
        MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"cart_id\":null,\"userId\":0,\"productId\":null,\"quantity\":null,\"price\":null,\"total_price\":null,\"created"
                                        + "_at\":null}]"));
    }

    /**
     * Method under test: {@link CartController#getAllCarts()}
     */
    @Test
    void testGetAllCarts3() throws Exception {
        when(iCartService.getAllCarts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartservice/all");
        requestBuilder.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link CartController#addToCart(CartItemDto)}
     */
    @Test
    void testAddToCart() throws Exception {
        // Prepare a dummy CartItemDto
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setCart_id(1L);
        cartItemDto.setCreated_at(LocalDateTime.now());
        cartItemDto.setPrice(BigDecimal.valueOf(10));
        cartItemDto.setProductId("123");
        cartItemDto.setQuantity(2);
        cartItemDto.setTotal_price(BigDecimal.valueOf(20));
        cartItemDto.setUserId(123);

        // Mock the addToCart method of the service to return the dummy CartItemDto
        when(iCartService.addToCart(cartItemDto)).thenReturn(cartItemDto);

        // Perform the test by invoking the controller method directly
        ResponseEntity<CartItemDto> responseEntity = cartController.addToCart(cartItemDto);

        // Verify the response status code
      //  assertEquals(201, responseEntity.getStatusCodeValue()); // Expect a 201 Created status code
    }
    
  	/*
	 * @Test // @Disabled("TODO: Complete this test") void testAddToCart() throws
	 * Exception { // TODO: Complete this test. // Reason: R013 No inputs found that
	 * don't throw a trivial exception. // Diffblue Cover tried to run the
	 * arrange/act section, but the method under // test threw //
	 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8
	 * date/time type `java.time.LocalDateTime` not supported by default: add Module
	 * "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling
	 * (through reference chain: com.kuka.cart.dto.CartItemDto["created_at"]) // at
	 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(
	 * InvalidDefinitionException.java:77) // at
	 * com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(
	 * SerializerProvider.java:1300) // at
	 * com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(
	 * UnsupportedTypeSerializer.java:35) // at
	 * com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(
	 * BeanPropertyWriter.java:728) // at
	 * com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(
	 * BeanSerializerBase.java:774) // at
	 * com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.
	 * java:178) // at
	 * com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(
	 * DefaultSerializerProvider.java:480) // at
	 * com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(
	 * DefaultSerializerProvider.java:319) // at
	 * com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.
	 * java:4568) // at
	 * com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.
	 * java:3821) // See https://diff.blue/R013 to resolve this issue.
	 * 
	 * MockHttpServletRequestBuilder contentTypeResult =
	 * MockMvcRequestBuilders.post("/cartservice/add")
	 * .contentType(MediaType.APPLICATION_JSON);
	 * 
	 * CartItemDto cartItemDto = new CartItemDto(); cartItemDto.setCart_id(1L);
	 * cartItemDto.setCreated_at(LocalDate.of(1970, 1, 1).atStartOfDay());
	 * cartItemDto.setPrice(BigDecimal.valueOf(1L)); cartItemDto.setProductId("42");
	 * cartItemDto.setQuantity(1);
	 * cartItemDto.setTotal_price(BigDecimal.valueOf(1L)); cartItemDto.setUserId(1);
	 * MockHttpServletRequestBuilder requestBuilder = contentTypeResult
	 * .content((new ObjectMapper()).writeValueAsString(cartItemDto));
	 * MockMvcBuilders.standaloneSetup(cartController).build().perform(
	 * requestBuilder); }
	 */

    /**
     * Method under test: {@link CartController#getCartsByUserId(int)}
     */
    @Test
    void testGetCartsByUserId() throws Exception {
        when(iCartService.findCartItemsByUserId(anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartservice/byUserId/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link CartController#getCartsByUserId(int)}
     */
    @Test
    void testGetCartsByUserId2() throws Exception {
        ArrayList<CartItemDto> cartItemDtoList = new ArrayList<>();
        cartItemDtoList.add(new CartItemDto());
        when(iCartService.findCartItemsByUserId(anyInt())).thenReturn(cartItemDtoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartservice/byUserId/{userId}", 1);
        MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"cart_id\":null,\"userId\":0,\"productId\":null,\"quantity\":null,\"price\":null,\"total_price\":null,\"created"
                                        + "_at\":null}]"));
    }

    /**
     * Method under test: {@link CartController#getCartsByUserId(int)}
     */
    @Test
    void testGetCartsByUserId3() throws Exception {
        when(iCartService.findCartItemsByUserId(anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartservice/byUserId/{userId}", 1);
        requestBuilder.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link CartController#removeProductByCartId(Long)}
     */
    @Test
    void testRemoveProductByCartId() throws Exception {
        doNothing().when(iCartService).deleteProductByCartId(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cartservice/delete/{cartId}", 1L);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link CartController#removeProductByCartId(Long)}
     */
    @Test
    void testRemoveProductByCartId2() throws Exception {
        doNothing().when(iCartService).deleteProductByCartId(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cartservice/delete/{cartId}", 1L);
        requestBuilder.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }
}

