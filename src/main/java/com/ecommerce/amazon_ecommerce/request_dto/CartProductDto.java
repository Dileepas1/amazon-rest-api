package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;

@Data
public class CartProductDto {

    private long customerId;

    private long productId;

    private int quantity;
}
