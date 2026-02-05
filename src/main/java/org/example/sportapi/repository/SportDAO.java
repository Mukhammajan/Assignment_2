package org.example.sportapi.repository;

import org.example.sportapi.model.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDAO implements SportRepository {

    @Override
    public void insert(Connection conn, Sport sport) throws SQLException {
        String sql = "INSERT INTO sport(name, category) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sport.getName());
            ps.setString(2, sport.getCategory());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Sport> findAll(Connection conn) throws SQLException {
        String sql = "SELECT id, name, category FROM sport ORDER BY id";
        List<Sport> list = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Sport(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category")
                ));
            }
        }
        return list;
    }

    @Override
    public int deleteById(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM sport WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
