package dao;

import domain.Ticket;
import java.util.ArrayList;

public interface TicketDao {
    void create(Ticket t);
    void update(Ticket t);
    Ticket searchById(int id);
    ArrayList<Ticket> findAll();
}
