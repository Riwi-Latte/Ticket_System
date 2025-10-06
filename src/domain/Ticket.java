package domain;

import java.time.LocalDateTime;

public class Ticket {

    private int ticketId;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status; 

    private Usuario assignedUser;
    private Usuario reportedUser;
    private Categoria category;


    public Ticket() {
    }

    public Ticket(int ticketId, String title, String description, LocalDateTime startDate,
                  LocalDateTime endDate, String status, Usuario assignedUser,
                  Usuario reportedUser, Categoria category) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.assignedUser = assignedUser;
        this.reportedUser = reportedUser;
        this.category = category;
    }


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Usuario assignedUser) {
        this.assignedUser = assignedUser;
    }

    public Usuario getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(Usuario reportedUser) {
        this.reportedUser = reportedUser;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", assignedUser=" + (assignedUser != null ? assignedUser.getNombre() : "null") +
                ", reportedUser=" + (reportedUser != null ? reportedUser.getNombre() : "null") +
                ", category=" + (category != null ? category.getNombre() : "null") +
                '}';
    }
}