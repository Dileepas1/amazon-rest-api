package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.request_dto.AddressDto;
import com.ecommerce.amazon_ecommerce.request_dto.CartProductDto;
import com.ecommerce.amazon_ecommerce.model.Address;
import com.ecommerce.amazon_ecommerce.model.CartProduct;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.request_dto.CustomerDto;
import com.ecommerce.amazon_ecommerce.service.CustomerService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "To Signup.")
    @PostMapping("/register")
    private Customer customerSignUp(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }

    @ApiOperation(value = "Customer can see his addresses.")
    @GetMapping("/{customerId}/address")
    private List<Address> displayAllAddress(@PathVariable long customerId){
        return customerService.displayAddress(customerId);
    }

    @ApiOperation(value = "Customer can add address to his profile.")
    @PostMapping("/{customerId}/address")
    private List<Address> addAddress(@RequestBody AddressDto addressDto, @PathVariable long customerId){
        return customerService.addressSave(addressDto);
    }

    @ApiOperation(value = "Customer can delete his address.")
    @DeleteMapping(value = "/{customerId}/address/{addressId}")
    private List<Address> removeAddress(@PathVariable long customerId, @PathVariable long addressId){
        return customerService.deleteAddress(customerId, addressId);
    }

    @ApiOperation(value = "Customer can see all the cart products.")
    @GetMapping("{customerId}/cart")
    private List<CartProduct> displayCart(@PathVariable long customerId){
        return customerService.getCartProducts(customerId);
    }

    @ApiOperation(value = "To add items to cart.")
    @PostMapping("/{customerId}/cart")
    private List<CartProduct> addToCart(@RequestBody CartProductDto cartProductDto){
        return customerService.addProductsToCart(cartProductDto);
    }

    @ApiOperation(value = "To update item quantity in his cart.")
    @PutMapping("/{customerId}/cart/update")
    private List<CartProduct> updateCart(@PathVariable long customerId,@RequestBody CartProductDto cartProductDto){
        return customerService.updateQuantityInCart(customerId,cartProductDto);
    }

    @ApiOperation(value = "Remove item from cart")
    @DeleteMapping("/{customerId}/cart/delete/{id}")
    private List<CartProduct> deleteItemInCart(@PathVariable long customerId, @PathVariable long id){
        return customerService.deleteItemInCart(customerId,id);
    }

    @GetMapping("/{customerId}/cart/buy")
    private float buy(@PathVariable long customerId){
        return customerService.totalAmount(customerId);
    }
}
