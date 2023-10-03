package com.kuka.plp.productService;

import com.kuka.plp.Dto.ProductDetails;
import com.kuka.plp.Entity.Product;
import com.kuka.plp.Repository.ProductRepository;
import com.kuka.plp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class PlpApplicationTests {

	@Test
	void contextLoads() {
	}


	@InjectMocks
	ProductService productService;

	@Mock
	ProductRepository productRepository;


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
	public  void getProductById() {

		given(productRepository.getProductById(product.getProductId())).
				willReturn(product);
		ProductDetails productDetails= productService.findById(product.getProductId());

		assertNotNull(productDetails);
	}


	@Test
	public  void getProductByName() {

		List<Product> productList = new ArrayList<>();
		productList.add(product);
		given(productRepository.getProductsByName(product.getName())).
				willReturn(productList);

		List<ProductDetails> productDetails= productService.getProductsByName(product.getName());

		assertEquals(productDetails.get(0).getProductId(),product.getProductId());

	}



}
