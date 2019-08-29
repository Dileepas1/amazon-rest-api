package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddressDto {

    private String street;

    private String city;

    private String pinCode;

    private String state;

    private long customerId;
}
