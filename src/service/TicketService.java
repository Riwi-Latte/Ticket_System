package service;

import dao.TicketDao;
import dao.TicketDaoImpl;
import domain.Ticket;

import javax.swing.JOptionPane;

public class TicketService {

    private TicketDao ticketDao;

    public TicketService() {
        this.ticketDao = new TicketDaoImpl();
    }

    public void createTicket(Ticket ticket) {
        if (ticket == null) {
            JOptionPane.showMessageDialog(null, "❌ El ticket no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ticket.getTitle() == null || ticket.getTitle().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El título del ticket es obligatorio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ticket.getReportedUser() == null) {
            JOptionPane.showMessageDialog(null, "Debe haber un usuario reportante.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (ticket.getStatus() == null || ticket.getStatus().isEmpty()) {
            ticket.setStatus("Open");
        }

        ticketDao.create(ticket);
        JOptionPane.showMessageDialog(null, "Ticket creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateTicket(Ticket ticket) {
        if (ticket == null || ticket.getTicketId() == 0) {
            JOptionPane.showMessageDialog(null, "Debe indicar un ticket existente para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ticketDao.update(ticket);
        JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public Ticket searchById(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "El ID debe ser mayor que cero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Ticket ticket = ticketDao.searchById(id);
        if (ticket == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un ticket con ese ID.", "No encontrado", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ticket encontrado:\n" + ticket.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }

        return ticket;
    }
}
