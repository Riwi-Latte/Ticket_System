package service;

import dao.TicketDao;
import dao.TicketDaoImpl;
import domain.Ticket;

public class TicketService {

    private TicketDao ticketDao;

    public TicketService() {
        this.ticketDao = new TicketDaoImpl();
    }

   
    public void crearTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("El ticket no puede ser nulo.");
        }
        if (ticket.getTitle() == null || ticket.getTitle().isEmpty()) {
            throw new IllegalArgumentException("El título del ticket es obligatorio.");
        }
        if (ticket.getReportedUser() == null) {
            throw new IllegalArgumentException("Debe haber un usuario reportante.");
        }

        if (ticket.getStatus() == null || ticket.getStatus().isEmpty()) {
            ticket.setStatus("Open");
        }

        ticketDao.crear(ticket);
    }
    

    public void actualizarTicket(Ticket ticket) {
        if (ticket == null || ticket.getTicketId() == 0) {
            throw new IllegalArgumentException("Debe indicar un ticket existente para actualizar.");
        }

        ticketDao.actualizar(ticket);
    }


    public Ticket buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }

        return ticketDao.buscarPorId(id);
    }
}
