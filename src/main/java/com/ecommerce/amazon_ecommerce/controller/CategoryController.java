package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.model.Category;
import com.ecommerce.amazon_ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public List<Category> displayAll(){
        return categoryService.getAll();
    }
}
