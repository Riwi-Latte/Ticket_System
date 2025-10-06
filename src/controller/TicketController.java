package controller;

import domain.Ticket;
import domain.User;
import domain.Category;
import service.TicketService;
import java.time.LocalDateTime;
import java.util.Locale.Category;

public class TicketController {

    private TicketService ticketService;

    public TicketController() {
        this.ticketService = new TicketService();
    }


    public void createTicket(String title, String description, int idUser, int idCategory) {
        try {
            User user = new User();
            user.setUserId(idUser);

            Category category = new Categoria();
            category.setCategoryId(idCategory);

            Ticket ticket = new Ticket();
            ticket.setTitle(title);
            ticket.setDescription(description);
            ticket.setStartDate(LocalDateTime.now());
            ticket.setStatus("Open");
            ticket.setReportedUser(user);
            ticket.setCategory(category);

            ticketService.createTicket(ticket);

            System.out.println("Ticket creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al crear el ticket: " + e.getMessage());
        }
    }


    public void updateTicket(int idTicket, String newTitle, String newDescription, String newStatus) {
        try {
            Ticket ticket = ticketService.searchById(idTicket);

            if (ticket == null) {
                System.out.println("No se encontró el ticket con ID " + idTicket);
                return;
            }

            ticket.setTitle(newTitle);
            ticket.setDescription(newDescription);
            ticket.setStatus(newStatus);

            ticketService.updateTicket(ticket);

            System.out.println("Ticket actualizado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al actualizar el ticket: " + e.getMessage());
        }
    }


    public void searchTicketById(int idTicket) {
        try {
            Ticket ticket = ticketService.searchById(idTicket);

            if (ticket != null) {
                System.out.println("Ticket encontrado:");
                System.out.println("ID: " + ticket.getTicketId());
                System.out.println("Título: " + ticket.getTitle());
                System.out.println("Descripción: " + ticket.getDescription());
                System.out.println("Estado: " + ticket.getStatus());
                System.out.println("Fecha de creación: " + ticket.getStartDate());
                System.out.println("Usuario reportante ID: " + ticket.getReportedUser().getUserId());
                System.out.println("Categoría ID: " + ticket.getCategory().getCategoryId());
            } else {
                System.out.println("No se encontró ningún ticket con ID " + idTicket);
            }

        } catch (Exception e) {
            System.out.println("Error al buscar el ticket: " + e.getMessage());
        }
    }
}
