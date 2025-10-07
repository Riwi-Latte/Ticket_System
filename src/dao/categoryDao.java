package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.categoryDomain;

public class categoryDao {
    
    private Connection connection; 

    public categoryDao(Connection connection) {
        this.connection = connection;
    }

    public void createCategoryDao(String name) {
        
        String sql = "INSERT INTO categories (category_name) VALUES (?)";
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategoryDao(int id) {
        
        String sql = "DELETE FROM categories WHERE category_id = ?";
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();    

        }

    }


    public ArrayList<categoryDomain> listCategoriesDao() {

        ArrayList<categoryDomain> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM categories";
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet res = ps.executeQuery();

        
            while (res.next()) {
                    lista.add(new categoryDomain(
                            res.getInt("category_id"),
                            res.getString("category_name")
                    ));
            }

            return lista;

        } catch (SQLException e) {
            e.printStackTrace();    
            return null;
        }

    }
}
