package com.kuka.plp.Repository;


import com.kuka.plp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

    @Query("from Product where product_id=:product_id")
    public Product getProductById(String product_id);
//    @Query("from Product where name LIKE 'name%'")
//    public List<Product> getProductsByName(String name);

    @Query("from Product where category_id = :category_id")
    public Product getProductByCategoryId(@Param("category_id") String categoryId);

    List<Product> findByCategoryId(String categoryId);


    @Query("FROM Product WHERE name LIKE CONCAT(:name, '%')")
    public List<Product> getProductsByName(@Param("name") String name);



}

