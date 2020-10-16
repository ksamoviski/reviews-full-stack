package org.wcci.reviewsfullstack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.reviewsfullstack.models.Category;
import org.wcci.reviewsfullstack.repositories.CategoryRepository;

import javax.annotation.Resource;

@Controller
public class CategoryController {

    @Resource
    private CategoryRepository categoryRepository;

    @RequestMapping({"/categories", "/",""})
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "categoriesView";
    }

    @GetMapping("/categories/{categoryType}")
    public String displaySingleCategory(@PathVariable String categoryType, Model model){
        Category retrievedCategory = categoryRepository.findCategoryByCategoryType(categoryType);
        model.addAttribute("category", retrievedCategory);
        return "categoryView";
    }

}
