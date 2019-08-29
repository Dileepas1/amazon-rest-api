package com.ecommerce.amazon_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="productId")
@Component
@Scope(value = "prototype")//,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
@Table(name = "product")
@Data
@Getter
@Setter
@ToString
public class Product {

    @Id
    private long productId;

    @Column(name = "product_name")
    private String productName;

    private double productPrice;

    private String productColor;

    private int availableQuantity;

    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "productCart")
    @JsonIgnore
    List<CartProduct> products;

    protected Product() {}
}