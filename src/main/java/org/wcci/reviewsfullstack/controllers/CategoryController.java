package org.wcci.reviewsfullstack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.reviewsfullstack.repositories.CategoryRepository;

import javax.annotation.Resource;

@Controller
public class CategoryController {

    @Resource
    private CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "categoriesView";
    }
}
