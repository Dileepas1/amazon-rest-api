package com.ecommerce.amazon_ecommerce.repository;

import com.ecommerce.amazon_ecommerce.model.CartProduct;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    List<CartProduct> findCartProductByCustomerCart(Customer customer);

    @Modifying
    @Transactional(readOnly = false)
    @Query("update CartProduct as c set c.quantity = ?2 where c.id = ?1")
    void setCartProductByCustomerCart(@Param("id") long id,@Param("quantity") int quantity);

    CartProduct getCartProductByCustomerCartAndProductCart(Customer customer, Product product);
}
