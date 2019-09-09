package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;

@Data
public class AddressDto {

    private String street;

    private String city;

    private String pinCode;

    private String state;

    private long customerId;
}
