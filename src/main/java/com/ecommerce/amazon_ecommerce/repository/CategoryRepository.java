package com.ecommerce.amazon_ecommerce.repository;

import com.ecommerce.amazon_ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCategoryId(int categoryId);
}
