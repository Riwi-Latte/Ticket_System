package view;

import controller.UserController;
import javax.swing.JOptionPane;

public class UserView {

    public static void showMenu(UserController controller) {
        String option;

        do {
            String menu = "=== GESTION DE USUARIOS ===\n\n" +
                          "1. Crear usuario\n" +
                          "2. Listar todos los usuarios\n" +
                          "3. Buscar usuario por ID\n" +
                          "4. Listar usuarios por rol\n" +
                          "5. Actualizar usuario\n" +
                          "6. Eliminar usuario\n" +
                          "0. Volver\n\n" +
                          "Seleccione una opcion:";

            option = JOptionPane.showInputDialog(null, menu);

            if (option == null) {
                return;
            }

            switch (option) {
            case "1":
                String fullName = JOptionPane.showInputDialog("Nombre completo:");
                if (fullName == null) break;

                String email = JOptionPane.showInputDialog("Email:");
                if (email == null) break;

                String phoneNumber = JOptionPane.showInputDialog("Telefono (opcional):");
                if (phoneNumber == null) phoneNumber = "";

                String roleOption = JOptionPane.showInputDialog(util.ValidationUtil.getRoleMenuOptions());
                if (roleOption == null) break;

                String role = util.ValidationUtil.getRoleFromOption(roleOption);
                if (role == null) {
                    JOptionPane.showMessageDialog(null, "Opcion de rol invalida");
                    break;
                }

                controller.createUser(fullName, email, phoneNumber, role);
                break;

            case "2":
                controller.listAllUsers();
                break;

            case "3":
                String userIdStr = JOptionPane.showInputDialog("Ingrese el ID del usuario:");
                if (userIdStr == null) break;

                if (!util.ValidationUtil.isValidInteger(userIdStr)) {
                    JOptionPane.showMessageDialog(null, "ID invalido. Debe ser un numero");
                    break;
                }

                controller.findUserById(util.ValidationUtil.parseInteger(userIdStr));
                break;

            case "4":
                String roleFilter = JOptionPane.showInputDialog("Ingrese el rol (Admin/Assignee/Reporter):");
                if (roleFilter != null) {
                    controller.listUsersByRole(roleFilter);
                }
                break;

            case "5":
                String updateIdStr = JOptionPane.showInputDialog("Ingrese el ID del usuario a actualizar:");
                if (updateIdStr == null) break;

                if (!util.ValidationUtil.isValidInteger(updateIdStr)) {
                    JOptionPane.showMessageDialog(null, "ID invalido. Debe ser un numero");
                    break;
                }

                int updateId = util.ValidationUtil.parseInteger(updateIdStr);

                try {
                    domain.UserDomain currentUser = controller.getUserById(updateId);

                    String updateFullName = JOptionPane.showInputDialog("Nombre completo:", currentUser.getFullName());
                    if (updateFullName == null) break;

                    String updateEmail = JOptionPane.showInputDialog("Email:", currentUser.getEmail());
                    if (updateEmail == null) break;

                    String updatePhoneNumber = JOptionPane.showInputDialog("Telefono:", currentUser.getPhoneNumber());
                    if (updatePhoneNumber == null) updatePhoneNumber = "";

                    String updateRoleOption = JOptionPane.showInputDialog(util.ValidationUtil.getRoleMenuOptions());
                    if (updateRoleOption == null) break;

                    String updateRole = util.ValidationUtil.getRoleFromOption(updateRoleOption);
                    if (updateRole == null) {
                        JOptionPane.showMessageDialog(null, "Opcion de rol invalida");
                        break;
                    }

                    controller.updateUser(updateId, updateFullName, updateEmail, updatePhoneNumber, updateRole);

                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
                break;

            case "6":
                String deleteIdStr = JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar:");
                if (deleteIdStr == null) break;

                if (!util.ValidationUtil.isValidInteger(deleteIdStr)) {
                    JOptionPane.showMessageDialog(null, "ID invalido. Debe ser un numero");
                    break;
                }

                int deleteId = util.ValidationUtil.parseInteger(deleteIdStr);

                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Esta seguro de eliminar el usuario con ID " + deleteId + "?",
                    "Confirmar eliminacion",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    controller.deleteUser(deleteId);
                }
                break;

            case "0":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        } while (!option.equals("0"));
    }
}