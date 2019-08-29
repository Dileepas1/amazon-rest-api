package com.ecommerce.amazon_ecommerce.service;

import com.ecommerce.amazon_ecommerce.DTO.AddressDto;
import com.ecommerce.amazon_ecommerce.model.Address;
import com.ecommerce.amazon_ecommerce.model.CartProduct;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.model.Product;
import com.ecommerce.amazon_ecommerce.repository.AddressRepository;
import com.ecommerce.amazon_ecommerce.repository.CartProductRepository;
import com.ecommerce.amazon_ecommerce.repository.CustomerRepository;
import com.ecommerce.amazon_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;
    private CartProductRepository cartProductRepository;
    private ProductRepository productRepository;
    @Autowired
    Address address;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository, CartProductRepository cartProductRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public List<Address> displayAddress(long customerId){
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return addressRepository.findAddressByCustomer(customer);
    }

    public List<Address> itemSave(AddressDto addressDto) {
        address.setCity(addressDto.getCity());
        address.setPinCode(addressDto.getPinCode());
        address.setState(addressDto.getState());
        address.setStreet(addressDto.getStreet());

        long personId = addressDto.getCustomerId();
        Customer customer = customerRepository.findCustomerByCustomerId(personId);

        System.out.println(customer);
        address.setCustomer(customer);
        addressRepository.save(address);

        return addressRepository.findAddressByCustomer(customer);
    }

    public List<Address> deleteAddress(long customerId, long addressId) {
        addressRepository.deleteById(addressId);
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return addressRepository.findAddressByCustomer(customer);
    }

    public List<CartProduct> getCartProducts(long customerId){
        return cartProductRepository.findCartProductByCustomerCart(customerRepository.findCustomerByCustomerId(customerId));
    }

    public List<CartProduct> addProductsToCart(long customerId, long productId, int quantity) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        Product product = productRepository.findProductByProductId(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setCustomerCart(customer);
        cartProduct.setProductCart(product);
        cartProduct.setQuantity(quantity);
        cartProductRepository.save(cartProduct);
        return getCartProducts(customerId);
        
    }

    public List<CartProduct> updateQuantityInCart(long customerId, int quantity,long productId) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        Product product = productRepository.findProductByProductId(productId);
        CartProduct cartProduct=cartProductRepository.getCartProductByCustomerCartAndProductCart(customer,product);
        long id=cartProduct.getId();
        cartProductRepository.setCartProductByCustomerCart(id,quantity);
        return getCartProducts(customerId);
    }

    public List<CartProduct> deleteItemInCart(long customerId, long id) {
        cartProductRepository.deleteById(id);
        return getCartProducts(customerId);
    }
}
