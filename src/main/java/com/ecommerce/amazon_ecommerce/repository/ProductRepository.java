package com.ecommerce.amazon_ecommerce.repository;

import java.util.List;
import com.ecommerce.amazon_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String product_name);

    @Modifying
    @Transactional
    @Query("delete from Product where productId = ?1")
    void deleteByProductId(@Param("id") long id);

}