package view;

import controller.TicketController;
import javax.swing.JOptionPane;

public class TicketView {

    private TicketController controller;

    public TicketView() {
        controller = new TicketController();
    }

    public void mostrarMenu() {
        int option = 0;

        do {
            String menu = """
                    ===============================
                          GESTIÓN DE TICKETS
                    ===============================
                    1. Crear Ticket
                    2. Buscar Ticket por ID
                    3. Actualizar Ticket
                    4. Salir
                    """;

            String input = JOptionPane.showInputDialog(null, menu + "\nSeleccione una opción:", "Menú Principal", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {                
                return;
            }

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            switch (option) {
                case 1 -> createTicket();
                case 2 -> searchTicketById();
                case 3 -> updateTicket();
                case 4 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema...", "Salir", JOptionPane.INFORMATION_MESSAGE);
                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (option != 4);
    }

    

    private void createTicket() {
        String title = JOptionPane.showInputDialog("Título:");
        if (title == null) return;

        String description = JOptionPane.showInputDialog("Descripción:");
        if (description == null) return;

        String idUserStr = JOptionPane.showInputDialog("ID del usuario que reporta:");
        if (idUserStr == null) return;

        String idCategoryStr = JOptionPane.showInputDialog("ID de la categoría:");
        if (idCategoryStr == null) return;

        try {
            int idUser = Integer.parseInt(idUserStr);
            int idCategory = Integer.parseInt(idCategoryStr);
            controller.createTicket(title, description, idUser, idCategory);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los ID deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void searchTicketById() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del ticket:");
        if (idStr == null) return;

        try {
            int id = Integer.parseInt(idStr);
            controller.searchTicketById(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void updateTicket() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del ticket:");
        if (idStr == null) return;

        try {
            int id = Integer.parseInt(idStr);

            String newTitle = JOptionPane.showInputDialog("Nuevo título:");
            if (newTitle == null) return;

            String newDescription = JOptionPane.showInputDialog("Nueva descripción:");
            if (newDescription == null) return;

            String newStatus = JOptionPane.showInputDialog("Nuevo estado (Open, In Progress, Resolved, Closed):");
            if (newStatus == null) return;

            controller.updateTicket(id, newTitle, newDescription, newStatus);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
