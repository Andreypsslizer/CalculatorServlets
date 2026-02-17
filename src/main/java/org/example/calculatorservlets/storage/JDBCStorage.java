package org.example.calculatorservlets.storage;

import org.example.calculatorservlets.config.PgConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCStorage {
    private static JDBCStorage INSTANCE;

    private JDBCStorage() {}

    public static JDBCStorage getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new JDBCStorage();
        }
        return INSTANCE;
    }

    public void save(String operation) {
        try (Connection connection = PgConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO history(operation) VALUES (?)");
            preparedStatement.setString(1, operation);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> findAll() {
        try (Connection connection = PgConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM history");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> operations = new ArrayList<>();

            while (resultSet.next()) {
                operations.add(resultSet.getString("operation"));
            }
            return operations;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
