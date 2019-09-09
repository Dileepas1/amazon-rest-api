package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String username;

    private String email;

    private String phoneNo;

    private int age;

    private String password;
}
