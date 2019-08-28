package com.ecommerce.amazon_ecommerce.service;

import com.ecommerce.amazon_ecommerce.model.Product;
import com.ecommerce.amazon_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public List<Product> itemSave(Product product)
    {
        repository.save(product);
        return repository.findAll();
    }

    public List<Product> deleteProduct(long id)
    {
        repository.deleteByProductId(id);
        return repository.findAll();
    }

    public List<Product> findByProductName(String productName){
        return repository.findByProductName(productName);
    }

    public List<Product> filterProductByPrice(double price){
        return repository.findByProductPrice(price);
    }
}
