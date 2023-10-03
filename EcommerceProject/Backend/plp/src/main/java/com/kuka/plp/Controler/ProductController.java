package com.kuka.plp.Controler;
import com.kuka.plp.Dto.ProductDetails;
import com.kuka.plp.service.ProductService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/product")
//@Api(tags = "Product Controller", description = "API endpoints for managing products")

public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *
     * @return List<ProductDetails>
     */
    @GetMapping("/list")
    //@ApiOperation("Get all products")
    public ResponseEntity<List<ProductDetails>> getAllProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.valueOf(HttpStatus.OK.value()));
    }

    /**
     *
     * @param product_id
     * @return ProductDetails
     */

    @GetMapping("/p/{product_id}")
    //@ApiOperation("Get product by ID")
    public ResponseEntity<ProductDetails> getAllProducts(@PathVariable String product_id) {
        return new ResponseEntity<>(productService.findById(product_id), HttpStatus.valueOf(HttpStatus.OK.value()));
    }
    @GetMapping("/c/{category_id}")
    public ResponseEntity<List<ProductDetails>>getProductsById(@PathVariable String category_id){
        return new ResponseEntity<>(productService.fetchById(category_id),HttpStatus.valueOf(HttpStatus.OK.value()));
    }

    /**
     *
     * @param name
     * @return <List<ProductDetails>>
     */
    @GetMapping("/n/{name}")
    //@ApiOperation("Get product by name")
    public ResponseEntity<List<ProductDetails>> getProductsByName(@PathVariable String name) {
        return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.valueOf(HttpStatus.OK.value()));
    }

}

