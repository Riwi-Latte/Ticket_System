package controller;

import service.categoryService;

public class categoryController {

    private categoryService categoryService;

    public categoryController(categoryService categoryService) {
        this.categoryService = categoryService;
    };
    
    public boolean createCategoryController(String name) {
     
        return categoryService.createCategoryService(name);//true

    };

    public boolean deleteCategoryController(int id) {
     
        return categoryService.deleteCategoryService(id);

    };

    public String listCategoryController() {
     
        return categoryService.listCategoryService();

    };
}
