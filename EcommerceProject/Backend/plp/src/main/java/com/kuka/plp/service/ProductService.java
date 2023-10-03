package com.kuka.plp.service;

import com.kuka.plp.Dto.ProductDetails;
import com.kuka.plp.Entity.Product;
import com.kuka.plp.Repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     *
     * @return productList
     */
    public List<ProductDetails> findAll() {
        List<Product> productList = productRepository.findAll();
        return convertToProductDetails(productList);
    }

    public List<ProductDetails> fetchById(String category_id) {
////        Product product = productRepository.getProductByCategoryId(category_id);
        if("0".equals(category_id)){
            return this.findAll();
        }
        List<Product> isprodectsFound = productRepository.findByCategoryId(category_id);
        List<Product> productList = isprodectsFound;
        List<ProductDetails> products = new ArrayList<>();
        for( Product product: productList){
            products.add(converToProduct(product));
        }
        return products;
    }

    /**
     *
     * @param product_id
     * @return product
     */

    public ProductDetails findById(String product_id) {
        Product product = productRepository.getProductById(product_id);
        return converToProduct(product);
    }

    /**
     *
     * @param name
     * @return productList
     */
    public List<ProductDetails> getProductsByName(String name) {
        List<Product> productList  = productRepository.getProductsByName(name);
        return convertToProductDetails(productList);
    }

    /**
     *
     * @param productList
     * @return productDetails
     */

    public static List<ProductDetails> convertToProductDetails(List<Product> productList ){

        List<ProductDetails> productDetails=new ArrayList<>();

        for (Product product:productList){
            productDetails.add(converToProduct(product));
        }
        return productDetails;
    }

    /**
     *
     * @param product
     * @return productDetails
     */
    public static ProductDetails converToProduct(Product product ){

        ProductDetails productDetails=new ProductDetails();
        BeanUtils.copyProperties(product,productDetails);
        return productDetails;
    }
}
