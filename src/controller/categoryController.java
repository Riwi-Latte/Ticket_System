package controller;

import service.categoryService;

public class categoryController {

    private categoryService categoryService;

    public categoryController(categoryService categoryService) {
        this.categoryService = categoryService;
    };
    
    public boolean createCategoryController(String name) {
     
        return categoryService.createCategoryService(name);


    }
}
