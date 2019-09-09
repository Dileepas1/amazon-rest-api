package com.ecommerce.amazon_ecommerce.repository;

import java.util.List;
import com.ecommerce.amazon_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContaining(String productName);
    @Modifying
    @Transactional
    void deleteByProductId(long id);

    @Query("select p from Product p where productPrice <= ?1 ")
    List<Product> findByProductPrice(double price);

    Product findProductByProductId(long productId);
}