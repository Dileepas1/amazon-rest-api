package com.ecommerce.amazon_ecommerce.service;

import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.model.UserDetailsImpl;
import com.ecommerce.amazon_ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(s);

        if(customer == null)
            throw new UsernameNotFoundException("user not found");

        return new UserDetailsImpl(customer);
    }
}
