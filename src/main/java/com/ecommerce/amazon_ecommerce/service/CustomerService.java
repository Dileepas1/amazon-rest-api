package com.ecommerce.amazon_ecommerce.service;

import com.ecommerce.amazon_ecommerce.model.Address;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.repository.AddressRepository;
import com.ecommerce.amazon_ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public List<Address> displayAddress(long customerId){
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return addressRepository.findAddressByCustomer(customer);
    }

    public List<Address> itemSave(Address address,long customerId) {
        addressRepository.save(address);
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return addressRepository.findAddressByCustomer(customer);
    }

    public List<Address> deleteAddress(long customerId, long addressId) {
        addressRepository.deleteById(addressId);
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return addressRepository.findAddressByCustomer(customer);
    }
}
