package dao;

import domain.Ticket;
import domain.Usuario;
import domain.Categoria;

import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalDateTime;

public class TicketDaoImpl implements TicketDao {

    @Override
    public void create(Ticket ticket) {
        String sql = "INSERT INTO tickets (title, ticket_description, start_date, end_date, status, assigned_user_id, reported_user_id, category_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, ticket.getTitle());
            stmt.setString(2, ticket.getDescription());
            stmt.setTimestamp(3, Timestamp.valueOf(ticket.getStartDate()));
            stmt.setTimestamp(4, ticket.getEndDate() != null ? Timestamp.valueOf(ticket.getEndDate()) : null);
            stmt.setString(5, ticket.getStatus());
            stmt.setObject(6, ticket.getAssignedUser() != null ? ticket.getAssignedUser().getUserId() : null, Types.INTEGER);
            stmt.setObject(7, ticket.getReportedUser() != null ? ticket.getReportedUser().getUserId() : null, Types.INTEGER);
            stmt.setObject(8, ticket.getCategory() != null ? ticket.getCategory().getCategoryId() : null, Types.INTEGER);

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ticket.setTicketId(rs.getInt(1));
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Ticket creado correctamente con ID: " + ticket.getTicketId(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al crear el ticket:\n" + e.getMessage(),
                    "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Ticket ticket) {
        String sql = "UPDATE tickets SET title = ?, ticket_description = ?, end_date = ?, status = ?, assigned_user_id = ?, category_id = ? " +
                     "WHERE ticket_id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticket.getTitle());
            stmt.setString(2, ticket.getDescription());
            stmt.setTimestamp(3, ticket.getEndDate() != null ? Timestamp.valueOf(ticket.getEndDate()) : null);
            stmt.setString(4, ticket.getStatus());
            stmt.setObject(5, ticket.getAssignedUser() != null ? ticket.getAssignedUser().getUserId() : null, Types.INTEGER);
            stmt.setObject(6, ticket.getCategory() != null ? ticket.getCategory().getCategoryId() : null, Types.INTEGER);
            stmt.setInt(7, ticket.getTicketId());

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null,
                        "Ticket actualizado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encontró un ticket con ese ID.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el ticket:\n" + e.getMessage(),
                    "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Ticket searchById(int id) {
        String sql = "SELECT * FROM tickets WHERE ticket_id = ?";
        Ticket ticket = null;

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticket = new Ticket();
                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("ticket_description"));

                Timestamp startTs = rs.getTimestamp("start_date");
                if (startTs != null) ticket.setStartDate(startTs.toLocalDateTime());

                Timestamp endTs = rs.getTimestamp("end_date");
                if (endTs != null) ticket.setEndDate(endTs.toLocalDateTime());

                ticket.setStatus(rs.getString("status"));

                Usuario assigned = new Usuario();
                assigned.setUserId(rs.getInt("assigned_user_id"));
                ticket.setAssignedUser(assigned);

                Usuario reporter = new Usuario();
                reporter.setUserId(rs.getInt("reported_user_id"));
                ticket.setReportedUser(reporter);

                Categoria categoria = new Categoria();
                categoria.setCategoryId(rs.getInt("category_id"));
                ticket.setCategory(categoria);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encontró ningún ticket con ID: " + id,
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al buscar el ticket:\n" + e.getMessage(),
                    "Error SQL", JOptionPane.ERROR_MESSAGE);
        }

        return ticket;
    }
}
