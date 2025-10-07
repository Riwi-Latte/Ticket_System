package view;

import controller.UserController;
import javax.swing.JOptionPane;

public class MainView {

    public static void start(UserController userController, categoryView categoryView) {
        String option;

        do {
            String menu = "=== SISTEMA DE SOPORTE - GESTION DE TICKETS ===\n\n" +
<<<<<<< HEAD
                    "1. Gestionar ticket\n" +
                    "2. Asignar ticket\n" +
                    "3. Cambiar estado\n" +
                    "4. Buscar por estado + categoria\n" +
                    "5. Listar por asignado\n" +
                    "6. Top 3 categorias\n" +
                    "7. Gestion de usuarios\n" +
                    "0. Salir\n\n" +
                    "Seleccione una opcion:";
=======
                          "1. Crear ticket\n" +
                          "2. Asignar ticket\n" +
                          "3. Cambiar estado\n" +
                          "4. Crear categoria\n" +
                          "5. Buscar por estado + categoria\n" +
                          "6. Listar por asignado\n" +
                          "7. Top 3 categorias\n" +
                          "8. Gestion de usuarios\n" +
                          "0. Salir\n\n" +
                          "Seleccione una opcion:";
>>>>>>> 10798eb82affb2d76c399108faee20f562fb16cb

            option = JOptionPane.showInputDialog(null, menu);

            if (option == null) {
                System.exit(0);
            }

            switch (option) {
                case "1":
                    TicketView view = new TicketView();
                    view.mostrarMenu();
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Asignar ticket");
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Cambiar estado");
                    break;

<<<<<<< HEAD
                case "4":
                    JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Buscar por estado + categoria");
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Listar por asignado");
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Top 3 categorias");
                    break;

                case "7":
                    UserView.showMenu(userController);
                    break;
=======
            case "4":
                categoryView.categoryMenu();
                break;

            case "5":
                JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Buscar por estado + categoria");
                break;

            case "6":
                JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Listar por asignado");
                break;

            case "7":
                JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo - Top 3 categorias");
                break;

            case "8":
                UserView.showMenu(userController);
                break;
>>>>>>> 10798eb82affb2d76c399108faee20f562fb16cb

                case "0":
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        } while (!option.equals("0"));
    }
}