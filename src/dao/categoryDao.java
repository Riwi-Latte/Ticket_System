package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DbConfig;
import domain.categoryDomain;

public class categoryDao {
    

    public categoryDao() {    
    };

    public void createCategoryDao(String name) {
        
            System.out.println("Creando categoria: " + name);
        String sql = "INSERT INTO categories (category_name) VALUES (?)";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int newId = generatedKeys.getInt(1);
                    System.out.println("Categoria creada con ID: " + newId);
                } else {
                    System.out.println("No se pudo obtener el ID de la nueva categoria.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategoryDao(int id) {
        
        String sql = "DELETE FROM categories WHERE category_id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();    

        }

    };


    public ArrayList<categoryDomain> listCategoriesDao() {

        ArrayList<categoryDomain> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM categories;";
        try (Connection conn = DbConfig.getConnection();
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
