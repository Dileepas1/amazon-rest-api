package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDto {

    private String productName;

    private double productPrice;

    private String productColor;

    private int availableQuantity;

    private String productDescription;

    private int category;
}
