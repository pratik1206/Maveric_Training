package com.kuka.plp.productController;


import com.kuka.plp.Controler.ProductController;
import com.kuka.plp.Dto.ProductDetails;
import com.kuka.plp.Entity.Product;
import com.kuka.plp.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)

public class ProductControllerTest {


    @Autowired
    MockMvc mockMvc;


    @MockBean
    ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;
    private Product product;

    @BeforeEach
    public void setup(){

        product = new Product();
        product.setProductId("01t1i0000005kaAAAQ");
        product.setCategoryId("310897");
        product.setName("ISO Flange");
        product.setDescription("products");
        product.setPrice(234.5);
        product.setStockQuantity(10897);
        product.setCreatedAt(Timestamp.valueOf("2023-08-17 15:02:49.000000"));
    }


    @Test
    public void GetAllProduct() throws Exception {


        List<Product> productList = new ArrayList<>();
        productList.add(product);


        String url = "/product/list";

        when(productService.findAll()).thenReturn(ProductService.convertToProductDetails(productList));

        mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print()).
                andExpect(status().isOk());

    }


    @Test
    public void GetAllProductBasedOnId() throws Exception {


        String url = "/product/p/01t1i0000005lErAAI";

        ProductDetails productDetails = new ProductDetails();
        BeanUtils.copyProperties(product,productDetails);

        when(productService.findById(product.getProductId())).thenReturn(productDetails);

        mockMvc.perform(get(url,product.getProductId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test

    public  void GetProductByName() throws  Exception
    {


        List<Product> productList = new ArrayList<>();
        productList.add(product);


        String url = "/product/n/Pan head screw, cross recess M2,5x6";

        when(productService.getProductsByName(product.getName())).thenReturn(ProductService.convertToProductDetails(productList));

        mockMvc.perform(get(url,product.getName())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

    }



    
}
