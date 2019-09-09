package com.ecommerce.amazon_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="categoryId")
@Data
public class Category {

    @Id
    private int categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<Product> products;
}
