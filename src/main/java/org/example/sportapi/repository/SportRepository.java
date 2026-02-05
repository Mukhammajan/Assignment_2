package org.example.sportapi.repository;

import org.example.sportapi.model.Sport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SportRepository {
    void insert(Connection conn, Sport sport) throws SQLException;
    List<Sport> findAll(Connection conn) throws SQLException;
    int deleteById(Connection conn, int id) throws SQLException;
}
