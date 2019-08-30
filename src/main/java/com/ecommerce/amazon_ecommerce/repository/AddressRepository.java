package com.ecommerce.amazon_ecommerce.repository;

import com.ecommerce.amazon_ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
