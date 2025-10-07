package app;

import dao.UserDao;
import dao.UserDaoImpl;
import dao.categoryDao;
import service.UserService;
import service.categoryService;


import controller.UserController;
import controller.categoryController;
import view.MainView;
import view.categoryView;

public class App {
    public static void main(String[] args) {
        try {
            // TODO: handle exception
        // Crear dependencias de abajo hacia arriba (Inyeccion de Dependencias)
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);

        // Crear dependencias para category
        categoryDao categoryDao = new categoryDao();
        categoryService categoryService = new categoryService(categoryDao);
        categoryController categoryController = new categoryController(categoryService);
        categoryView categoryView = new categoryView(categoryController);

        // Iniciar aplicacion
        MainView.start(userController ,categoryView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
