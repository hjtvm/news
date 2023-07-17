package com.ssm.service.impl;

import com.ssm.dao.CategoryDao;
import com.ssm.po.Category;
import com.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findCategoryList() {
        return this.categoryDao.selectCategoryList();
    }

    @Override
    public Category findCategoryById(Integer categoryId) {
        return this.categoryDao.getCategoryById(categoryId);
    }
}
