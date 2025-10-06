package dao;

import domain.Ticket;

public interface TicketDao {
    void create(Ticket t);
    void update(Ticket t);
    Ticket searchById(int id);
}
