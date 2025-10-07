package controller;

import domain.Ticket;
import domain.UserDomain;
import domain.categoryDomain;
import service.TicketService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TicketController {

    private TicketService ticketService;

    public TicketController() {
        this.ticketService = new TicketService();
    }

    public void createTicket(String title, String description, int idUser, int idCategory) {
        try {
            UserDomain user = new UserDomain();
            user.setUserId(idUser);

            categoryDomain category = new categoryDomain();
            category.setCategoryId(idCategory);

            Ticket ticket = new Ticket();
            ticket.setTitle(title);
            ticket.setDescription(description);
            ticket.setStartDate(LocalDateTime.now());
            ticket.setStatus("Open");
            ticket.setReportedUser(user);
            ticket.setCategory(category);

            ticketService.createTicket(ticket);

            JOptionPane.showMessageDialog(null,
                    "Ticket creado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al crear el ticket:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateTicket(int idTicket, String newTitle, String newDescription, String newStatus) {
        try {
            Ticket ticket = ticketService.searchById(idTicket);

            if (ticket == null) {
                JOptionPane.showMessageDialog(null,
                        "No se encontró el ticket con ID " + idTicket,
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            ticket.setTitle(newTitle);
            ticket.setDescription(newDescription);
            ticket.setStatus(newStatus);

            ticketService.updateTicket(ticket);

            JOptionPane.showMessageDialog(null,
                    "Ticket actualizado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el ticket:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchTicketById(int idTicket) {
        try {
            Ticket ticket = ticketService.searchById(idTicket);

            if (ticket != null) {
                String info = "Ticket encontrado:\n"
                        + "ID: " + ticket.getTicketId() + "\n"
                        + "Título: " + ticket.getTitle() + "\n"
                        + "Descripción: " + ticket.getDescription() + "\n"
                        + "Estado: " + ticket.getStatus() + "\n"
                        + "Fecha de creación: " + ticket.getStartDate() + "\n"
                        + "Usuario reportante ID: " + ticket.getReportedUser().getUserId() + "\n"
                        + "Categoría ID: " + ticket.getCategory().getCategoryId();

                JOptionPane.showMessageDialog(null,
                        info,
                        "Detalles del Ticket",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encontró ningún ticket con ID " + idTicket,
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al buscar el ticket:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Ticket> findAll() {
        ArrayList<Ticket> tickets = ticketService.findAll();
        return tickets;
    }
}
