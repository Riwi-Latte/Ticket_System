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

    public void deleteCategoryService(int id) {
    
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
        }


        return false;
   
    };
}
