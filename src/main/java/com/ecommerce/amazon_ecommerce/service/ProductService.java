package com.ecommerce.amazon_ecommerce.service;

import com.ecommerce.amazon_ecommerce.request_dto.ProductDto;
import com.ecommerce.amazon_ecommerce.model.Category;
import com.ecommerce.amazon_ecommerce.model.Product;
import com.ecommerce.amazon_ecommerce.repository.CategoryRepository;
import com.ecommerce.amazon_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;
    private CategoryRepository categoryRepository;
    private Product product;

    @Autowired
    public ProductService(ProductRepository repository, CategoryRepository categoryRepository, Product product) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.product = product;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public List<Product> itemSave(ProductDto productDto)
    {
        product.setProductName(productDto.getProductName());
        product.setAvailableQuantity(productDto.getAvailableQuantity());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductColor(productDto.getProductColor());
        product.setProductDescription(productDto.getProductDescription());

        int categoryNo = productDto.getCategory();
        Category category = categoryRepository.findCategoryByCategoryId(categoryNo);

        product.setCategory(category);
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
