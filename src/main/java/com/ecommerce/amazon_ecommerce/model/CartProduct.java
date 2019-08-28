package com.ecommerce.amazon_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerCart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productCart;

    @Column(name="quantity")
    private int quantity;

    public CartProduct(){}

   public Customer getCustomerCart() {
       return customerCart;
    }

    public void setCustomerCart(Customer customerCart) {
        this.customerCart = customerCart;
    }

    public Product getProductCart() {
        return productCart;
    }

    public void setProductCart(Product productCart) {
        this.productCart = productCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "customerCart=" + customerCart.getCustomerId() +
                ", productCart=" + productCart.getProductId() +
                ", quantity=" + quantity +
                '}';
    }
}
