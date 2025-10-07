package util;

public class ValidationUtil {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final String ROLE_REGEX = "^(Admin|Assignee|Reporter)$";

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public static boolean isValidRole(String role) {
        return role != null && role.matches(ROLE_REGEX);
    }

    public static boolean isValidInteger(String value) {
        if (isNullOrEmpty(value)) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int parseInteger(String value) {
        return Integer.parseInt(value);
    }

    public static String getRoleFromOption(String option) {
        switch (option) {
            case "1":
                return "Admin";
            case "2":
                return "Assignee";
            case "3":
                return "Reporter";
            default:
                return null;
        }
    }

    public static String getRoleMenuOptions() {
        return "Seleccione el rol:\n1. Admin\n2. Assignee\n3. Reporter";
    }
}
