package dao;

import domain.UserDomain;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {

    void create(UserDomain user) throws SQLException;

    UserDomain findById(int userId) throws SQLException;

    ArrayList<UserDomain> findAll() throws SQLException;

    ArrayList<UserDomain> findByRole(String role) throws SQLException;

    void update(UserDomain user) throws SQLException;

    void delete(int userId) throws SQLException;
}
