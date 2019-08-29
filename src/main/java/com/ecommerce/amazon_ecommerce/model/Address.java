package com.ecommerce.amazon_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="addressId")
@Table(name = "address")
@Data
@Getter
@Setter
@ToString
public class Address {

    @Id
    private long addressId;
    private String street;
    private String city;
    private String pinCode;
    private String state;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}