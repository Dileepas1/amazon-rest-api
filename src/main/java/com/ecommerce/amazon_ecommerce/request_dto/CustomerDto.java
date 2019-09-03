package com.ecommerce.amazon_ecommerce.request_dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerDto {

    private String username;
    private String email;
    private String phoneNo;
    private int age;
    private String password;
}
