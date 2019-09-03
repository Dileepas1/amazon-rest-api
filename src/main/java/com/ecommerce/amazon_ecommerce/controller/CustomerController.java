package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.request_dto.AddressDto;
import com.ecommerce.amazon_ecommerce.request_dto.CartProductDto;
import com.ecommerce.amazon_ecommerce.model.Address;
import com.ecommerce.amazon_ecommerce.model.CartProduct;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.request_dto.CustomerDto;
import com.ecommerce.amazon_ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    private List<Customer> displayAll(){
        return customerService.getAll();
    }

    @PostMapping("/register")
    private Customer customerSignUp(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }

    @GetMapping("/{customerId}/address")
    private List<Address> displayAllAddress(@PathVariable long customerId){
        return customerService.displayAddress(customerId);
    }

    @PostMapping("/{customerId}/address")
    private List<Address> storeAddress(@RequestBody AddressDto addressDto, @PathVariable long customerId){
        return customerService.itemSave(addressDto);
    }

    @DeleteMapping(value = "/{customerId}/address/{addressId}")
    private List<Address> deleteByProductId(@PathVariable long customerId, @PathVariable long addressId){
        return customerService.deleteAddress(customerId, addressId);
    }

    @GetMapping("{customerId}/cart")
    private List<CartProduct> displayCart(@PathVariable long customerId){
        return customerService.getCartProducts(customerId);
    }

    @PostMapping("/{customerId}/cart")
    private List<CartProduct> addToCart(@RequestBody CartProductDto cartProductDto){
        return customerService.addProductsToCart(cartProductDto);
    }

    @PutMapping("/{customerId}/cart/update/{productId}/{quantity}")
    private List<CartProduct> updateCart(@PathVariable long customerId,@PathVariable long productId, @PathVariable int quantity){
        return customerService.updateQuantityInCart(customerId,quantity,productId);
    }

    @DeleteMapping("/{customerId}/cart/delete/{id}")
    private List<CartProduct> deleteItemInCart(@PathVariable long customerId, @PathVariable long id){
        return customerService.deleteItemInCart(customerId,id);
    }
}
