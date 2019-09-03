package com.ecommerce.amazon_ecommerce.service;

import com.ecommerce.amazon_ecommerce.request_dto.AddressDto;
import com.ecommerce.amazon_ecommerce.request_dto.CartProductDto;
import com.ecommerce.amazon_ecommerce.model.Address;
import com.ecommerce.amazon_ecommerce.model.CartProduct;
import com.ecommerce.amazon_ecommerce.model.Customer;
import com.ecommerce.amazon_ecommerce.model.Product;
import com.ecommerce.amazon_ecommerce.repository.AddressRepository;
import com.ecommerce.amazon_ecommerce.repository.CartProductRepository;
import com.ecommerce.amazon_ecommerce.repository.CustomerRepository;
import com.ecommerce.amazon_ecommerce.repository.ProductRepository;
import com.ecommerce.amazon_ecommerce.request_dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;
    private CartProductRepository cartProductRepository;
    private ProductRepository productRepository;
    private Address address;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository, CartProductRepository cartProductRepository, ProductRepository productRepository, Address address) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
        this.address = address;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public List<Address> displayAddress(long customerId){
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return customer.getAddress();
    }

    public List<Address> itemSave(AddressDto addressDto) {
        address.setCity(addressDto.getCity());
        address.setPinCode(addressDto.getPinCode());
        address.setState(addressDto.getState());
        address.setStreet(addressDto.getStreet());

        long personId = addressDto.getCustomerId();
        Customer customer = customerRepository.findCustomerByCustomerId(personId);

        address.setCustomer(customer);
        addressRepository.save(address);

        return customer.getAddress();
    }

    public List<Address> deleteAddress(long customerId, long addressId) {
        addressRepository.deleteById(addressId);
        Customer customer=customerRepository.findCustomerByCustomerId(customerId);
        return customer.getAddress();
    }

    public List<CartProduct> getCartProducts(long customerId){
        return cartProductRepository.findCartProductByCustomerCart(customerRepository.findCustomerByCustomerId(customerId));
    }

    public List<CartProduct> addProductsToCart(CartProductDto cartProductDto) {
        long customerId = cartProductDto.getCustomerId();
        long productId = cartProductDto.getProductId();
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        Product product = productRepository.findProductByProductId(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setCustomerCart(customer);
        cartProduct.setProductCart(product);
        cartProduct.setQuantity(cartProductDto.getQuantity());
        cartProductRepository.save(cartProduct);
        return customer.getCartProduct();
    }

    public List<CartProduct> updateQuantityInCart(long customerId, int quantity,long productId) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        Product product = productRepository.findProductByProductId(productId);
        CartProduct cartProduct=cartProductRepository.getCartProductByCustomerCartAndProductCart(customer,product);
        long id=cartProduct.getId();
        cartProductRepository.setCartProductByCustomerCart(id,quantity);
        return customer.getCartProduct();
    }

    public List<CartProduct> deleteItemInCart(long customerId, long id) {
        cartProductRepository.deleteById(id);
        return getCartProducts(customerId);
    }

    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setUsername(customerDto.getUsername());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNo(customerDto.getPhoneNo());
        customer.setAge(customerDto.getAge());
        customer.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
        customerRepository.save(customer);
        return customerRepository.findCustomerByPhoneNo(customerDto.getPhoneNo());
    }
}
