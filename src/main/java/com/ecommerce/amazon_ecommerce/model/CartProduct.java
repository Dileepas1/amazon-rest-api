package com.ecommerce.amazon_ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
@Data
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
}
