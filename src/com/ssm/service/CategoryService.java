package com.ssm.service;

import com.ssm.po.Category;

import java.util.List;

/**
 * @author lenovo
 */
public interface CategoryService {
    public List<Category> findCategoryList();
    public Category findCategoryById(Integer categoryId);
}
