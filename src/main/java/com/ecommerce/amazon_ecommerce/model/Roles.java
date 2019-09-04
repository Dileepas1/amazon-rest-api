package com.ecommerce.amazon_ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Roles {

    @Id
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
