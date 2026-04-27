package com.example.todo_java.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class TodoJdbcRepository {

    private final DataSource dataSource;

    public Todo findById(Long id) {
        String sql = "SELECT t.*, u.email as user_email FROM todos t JOIN users u ON t.user_id = u.id WHERE t.id = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getLong("id"));
                todo.setTitle(rs.getString("title"));
                todo.setContent(rs.getString("content"));
                todo.setDone(rs.getBoolean("done"));
                return todo;
            }
            throw new RuntimeException("Todo not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}