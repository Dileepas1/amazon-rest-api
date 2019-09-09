package com.ecommerce.amazon_ecommerce.controller;

import com.ecommerce.amazon_ecommerce.model.Category;
import com.ecommerce.amazon_ecommerce.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    private CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Return available categories.")
    @GetMapping("/categories")
    private List<Category> displayAll(){
        return categoryService.getAll();
    }
}
