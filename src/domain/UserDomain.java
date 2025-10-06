package domain;

public class UserDomain {

    private int userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;

    public UserDomain() {
    }

    public UserDomain(int userId, String fullName, String email, String phoneNumber, String role) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + userId +
                ", Name: " + fullName +
                ", Email: " + email +
                ", Phone: " + phoneNumber +
                ", Role: " + role;
    }
}
