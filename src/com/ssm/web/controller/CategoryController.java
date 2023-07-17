package com.ssm.web.controller;

import com.ssm.po.Category;
import com.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lenovo
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/findCategoryList.action")
    public String findCategoryList(Model model){
        List<Category> categoryList = categoryService.findCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "category/category_list";
    }
}
