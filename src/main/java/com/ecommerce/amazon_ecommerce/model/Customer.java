package com.ecommerce.amazon_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="customerId")
@Table(name = "customer")
@Data
@Getter
@Setter
@ToString
public class Customer {

    @Id
    private long customerId;
    private String username;
    private String email;
    @Column(name = "phone_no")
    private String phoneNo;
    private int age;
    private String password;


    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    List<Address> address;

    @OneToMany(mappedBy = "customerCart")
    @JsonIgnore
    List<CartProduct> cartProduct;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    @JsonIgnore
    List<Roles> roles;

    public Customer() {}
}
