package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CartProductDto {

    private long customerId;

    private long productId;

    private int quantity;
}
