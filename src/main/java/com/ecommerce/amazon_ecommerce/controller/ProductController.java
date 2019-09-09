package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.request_dto.ProductDto;
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
    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    private List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/addProducts")
    private List<Product> addItem(@RequestBody ProductDto productDto){
        return productService.itemSave(productDto);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}")
    private List<Product> deleteByProductId(@PathVariable long productId){
        return productService.deleteProduct(productId);
    }

    @GetMapping("/search/{productName}")
    private List<Product> searchItem(@PathVariable String productName){
        return productService.findByProductName(productName);
    }

    @GetMapping("/filter/{productPrice}")
    private List<Product> filterItem(@PathVariable double productPrice){
        return productService.filterProductByPrice(productPrice);
    }
}