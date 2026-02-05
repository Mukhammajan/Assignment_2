package org.example.sportapi.service;

import org.example.sportapi.config.DBConnection;
import org.example.sportapi.model.Sport;
import org.example.sportapi.repository.SportRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class SportService {

    private final SportRepository repo;

    public SportService(SportRepository repo) {
        this.repo = repo;
    }

    public List<Sport> getAll() {
        try (Connection conn = DBConnection.getConnection()) {
            return repo.findAll(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Sport sport) {
        try (Connection conn = DBConnection.getConnection()) {
            repo.insert(conn, sport);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int delete(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            return repo.deleteById(conn, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
