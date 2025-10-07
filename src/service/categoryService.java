package service;


import java.util.ArrayList;

import dao.categoryDao;
import domain.categoryDomain;

public class categoryService {

    private categoryDao categoryDao;

    public categoryService(categoryDao categoryDao) {
        this.categoryDao = categoryDao;
    };
    
    public boolean createCategoryService(String name) {
     
        boolean exists = foundCategoriesService(name);

        if (!exists) {
            categoryDao.createCategoryDao(name);
            return true;
        }
        return false;

    };

    public boolean deleteCategoryService(int id) {

        boolean exists = foundCategoriesServiceById(id);

        if (exists) {
            categoryDao.deleteCategoryDao(id);
            return true;
        }
    
        return false;
    };

    public Boolean foundCategoriesService(String name) {
        
        ArrayList<categoryDomain> list = categoryDao.listCategoriesDao();

        if (name == null || name.isEmpty()) {
            return true;
        }

        for (categoryDomain category : list) {
            if (category.getCategoryName().equalsIgnoreCase(name)) {
                return true;
            }
        };
        return false;
   
    };

    public Boolean foundCategoriesServiceById(int id) {
        
        ArrayList<categoryDomain> list = categoryDao.listCategoriesDao();

        if (id <= 0) {
            return false;
        }

        for (categoryDomain category : list) {
            if (category.getCategoryId() == id) {
                return true;
            }
        };
        return false;
   
    };

    public String listCategoryService() {
        
        ArrayList<categoryDomain> list = categoryDao.listCategoriesDao();

        if (list.isEmpty()) {
            return "No hay categorias registradas";
        }

        StringBuilder result = new StringBuilder("Lista de Categorias:\n\n");
        for (categoryDomain category : list) {
            result.append(category.toString()).append("\n");
        }

        return result.toString();
    };
}
