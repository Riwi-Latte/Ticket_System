package controller;

import domain.Ticket;
import domain.Usuario;
import domain.Categoria;
import service.TicketService;
import java.time.LocalDateTime;

public class TicketController {

    private TicketService ticketService;

    public TicketController() {
        this.ticketService = new TicketService();
    }


    public void crearTicket(String titulo, String descripcion, int idUsuario, int idCategoria) {
        try {
            Usuario usuario = new Usuario();
            usuario.setUserId(idUsuario);

            Categoria categoria = new Categoria();
            categoria.setCategoryId(idCategoria);

            Ticket ticket = new Ticket();
            ticket.setTitle(titulo);
            ticket.setDescription(descripcion);
            ticket.setStartDate(LocalDateTime.now());
            ticket.setStatus("Open");
            ticket.setReportedUser(usuario);
            ticket.setCategory(categoria);

            ticketService.crearTicket(ticket);

            System.out.println("Ticket creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al crear el ticket: " + e.getMessage());
        }
    }


    public void actualizarTicket(int idTicket, String nuevoTitulo, String nuevaDescripcion, String nuevoEstado) {
        try {
            Ticket ticket = ticketService.buscarPorId(idTicket);

            if (ticket == null) {
                System.out.println("No se encontró el ticket con ID " + idTicket);
                return;
            }

            ticket.setTitle(nuevoTitulo);
            ticket.setDescription(nuevaDescripcion);
            ticket.setStatus(nuevoEstado);

            ticketService.actualizarTicket(ticket);

            System.out.println("Ticket actualizado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al actualizar el ticket: " + e.getMessage());
        }
    }


    public void buscarTicketPorId(int idTicket) {
        try {
            Ticket ticket = ticketService.buscarPorId(idTicket);

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
