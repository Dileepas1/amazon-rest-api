package com.ecommerce.amazon_ecommerce.model;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomerCart() { return customerCart; }

    public void setCustomerCart(Customer customerCart) { this.customerCart = customerCart; }

    public Product getProductCart() { return productCart; }

    public void setProductCart(Product productCart) { this.productCart = productCart; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "CartProduct{" +
                "customer=" + customerCart +
                ", product=" + productCart +
                ", quantity=" + quantity +
                '}';
    }
}
