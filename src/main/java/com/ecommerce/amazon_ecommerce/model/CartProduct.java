package com.ecommerce.amazon_ecommerce.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
@Data
@Getter
@Setter
@ToString
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
