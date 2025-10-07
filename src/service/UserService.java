package service;

import dao.UserDao;
import domain.UserDomain;
import util.ValidationUtil;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String fullName, String email, String phoneNumber, String role) {
        // Validaciones
        if (ValidationUtil.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException("El nombre es requerido");
        }
        if (!ValidationUtil.isValidEmail(email)) {
            throw new IllegalArgumentException("Email invalido");
        }
        if (!ValidationUtil.isValidRole(role)) {
            throw new IllegalArgumentException("Rol invalido. Debe ser Admin, Assignee o Reporter");
        }

        UserDomain user = new UserDomain(0, fullName, email, phoneNumber, role);

        try {
            userDao.create(user);
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar usuario en la base de datos", e);
        }
    }

    public ArrayList<UserDomain> getAllUsers() {
        try {
            return userDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener usuarios", e);
        }
    }

    public UserDomain getUserById(int userId) {
        try {
            UserDomain user = userDao.findById(userId);
            if (user == null) {
                throw new RuntimeException("Usuario no encontrado");
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar usuario", e);
        }
    }

    public ArrayList<UserDomain> getUsersByRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("El rol es requerido");
        }

        try {
            return userDao.findByRole(role);
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar usuarios por rol", e);
        }
    }

    public void updateUser(int userId, String fullName, String email, String phoneNumber, String role) {
        // Validaciones
        if (ValidationUtil.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException("El nombre es requerido");
        }
        if (!ValidationUtil.isValidEmail(email)) {
            throw new IllegalArgumentException("Email invalido");
        }
        if (!ValidationUtil.isValidRole(role)) {
            throw new IllegalArgumentException("Rol invalido. Debe ser Admin, Assignee o Reporter");
        }

        UserDomain user = new UserDomain(userId, fullName, email, phoneNumber, role);

        try {
            userDao.update(user);
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario", e);
        }
    }

    public void deleteUser(int userId) {
        try {
            userDao.delete(userId);
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar usuario", e);
        }
    }
}