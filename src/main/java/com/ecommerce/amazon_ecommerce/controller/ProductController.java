package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.model.Product;
import com.ecommerce.amazon_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/products")
    public List<Product> getItem(@RequestBody Product product){
        return productService.itemSave(product);
    }

    @DeleteMapping(value = "/products/{productId}")
    public List<Product> deleteByProductId(@PathVariable long productId){
        return productService.deleteProduct(productId);
    }

    @GetMapping("/search/{productName}")
    public List<Product> searchItem(@PathVariable String productName){
        return productService.findByProductName(productName);
    }

    @GetMapping("/filter/{productPrice}")
    public List<Product> filterItem(@PathVariable double productPrice){
        return productService.filterProductByPrice(productPrice);
    }

}