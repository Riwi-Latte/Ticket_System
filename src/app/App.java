package app;

import dao.UserDao;
import dao.UserDaoImpl;
import service.UserService;
import controller.UserController;
import view.MainView;

public class App {
    public static void main(String[] args) {
        // Crear dependencias de abajo hacia arriba (Inyeccion de Dependencias)
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);

        // Iniciar aplicacion
        MainView.start(userController);
    }
}
