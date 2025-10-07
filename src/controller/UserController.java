package controller;

import service.UserService;
import domain.UserDomain;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String fullName, String email, String phoneNumber, String role) {
        try {
            userService.createUser(fullName, email, phoneNumber, role);
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de validacion: " + e.getMessage());

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void listAllUsers() {
        try {
            ArrayList<UserDomain> users = userService.getAllUsers();

            if (users.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
                return;
            }

            StringBuilder result = new StringBuilder("Lista de Usuarios:\n\n");
            for (UserDomain user : users) {
                result.append(user.toString()).append("\n");
            }

            JOptionPane.showMessageDialog(null, result.toString());

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        }
    }

    public void findUserById(int userId) {
        try {
            UserDomain user = userService.getUserById(userId);
            JOptionPane.showMessageDialog(null, "Usuario encontrado:\n" + user.toString());

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de validacion: " + e.getMessage());

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public UserDomain getUserById(int userId) {
        return userService.getUserById(userId);
    }

    public void listUsersByRole(String role) {
        try {
            ArrayList<UserDomain> users = userService.getUsersByRole(role);

            if (users.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay usuarios con el rol: " + role);
                return;
            }

            StringBuilder result = new StringBuilder("Usuarios con rol " + role + ":\n\n");
            for (UserDomain user : users) {
                result.append(user.toString()).append("\n");
            }

            JOptionPane.showMessageDialog(null, result.toString());

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de validacion: " + e.getMessage());

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updateUser(int userId, String fullName, String email, String phoneNumber, String role) {
        try {
            userService.updateUser(userId, fullName, email, phoneNumber, role);
            JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de validacion: " + e.getMessage());

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {
        try {
            userService.deleteUser(userId);
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de validacion: " + e.getMessage());

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}