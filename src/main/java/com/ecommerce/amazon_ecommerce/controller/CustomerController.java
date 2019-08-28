package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.model.Address;
import com.ecommerce.amazon_ecommerce.model.CartProduct;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> displayAll(){
        return customerService.getAll();
    }

    @GetMapping("/{customerId}/address")
    public List<Address> displayAllAddress(@PathVariable long customerId){
        return customerService.displayAddress(customerId);
    }

    @PostMapping("/{customerId}/address")
    public List<Address> storeAddress(@RequestBody Address address, @PathVariable long customerId){
        return customerService.itemSave(address,customerId);
    }

    @DeleteMapping(value = "/{customerId}/address/{addressId}")
    public List<Address> deleteByProductId(@PathVariable long customerId, @PathVariable long addressId){
        return customerService.deleteAddress(customerId, addressId);
    }

    @GetMapping("{customerId}/cart")
    public List<CartProduct> displayCart(@PathVariable long customerId){
        return customerService.getCartProducts(customerId);
    }

    @PostMapping("/{customerId}/cart/{productId}/{quantity}")
    public List<CartProduct> addToCart(@PathVariable long customerId,@PathVariable long productId, @PathVariable int quantity){
        return customerService.addProductsToCart(customerId, productId, quantity);
    }

    @PutMapping("/{customerId}/cart/update/{productId}/{quantity}")
    public List<CartProduct> updateCart(@PathVariable long customerId,@PathVariable long productId, @PathVariable int quantity){
        return customerService.updateQuantityInCart(customerId,quantity,productId);
    }

    @DeleteMapping("/{customerId}/cart/delete/{id}")
    public List<CartProduct> deleteItemInCart(@PathVariable long customerId, @PathVariable long id){
        return customerService.deleteItemInCart(customerId,id);
    }
}
