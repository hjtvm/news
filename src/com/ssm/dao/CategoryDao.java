package com.ssm.dao;

import com.ssm.po.Category;

import java.util.List;

/**
 * @author lenovo
 */
public interface CategoryDao {
    public List<Category> selectCategoryList();
    public Category getCategoryById(Integer categoryId);
}
