package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/systemosdb";
    private static final String USER = "admin";
    private static final String PASS = "abcd1234";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Database connection error", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error while closing database connection");
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        closeConnection(connection);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error while closing statement");
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet result) {
        closeConnection(connection, statement);
        try {
            if (result != null) {
                result.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error while closing result set");
        }
    }
}
