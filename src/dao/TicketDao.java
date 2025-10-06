package dao;

import domain.Ticket;

public interface TicketDao {
    void crear(Ticket t);
    void actualizar(Ticket t);
    Ticket buscarPorId(int id);
}
