package com.ecommerce.amazon_ecommerce.repository;

import com.ecommerce.amazon_ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByCustomerId(long customerId);

    Customer findByUsername(String s);

    Customer findCustomerByPhoneNo(String phoneNo);
}
