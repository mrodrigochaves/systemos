package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import util.ConnectionFactory;

public class OrderController {

    public void save(Order order) {
        String sql = "INSERT INTO orders(orderId, type, description, status, createdAt, updatedAt)"
                + " VALUES (?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getType());
            statement.setString(3, order.getDescription());
            statement.setString(4, order.getStatus());
            statement.setDate(5, new java.sql.Date(order.getCreatedAt().getTime()));
            statement.setDate(6, new java.sql.Date(order.getUpdatedAt().getTime()));
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while saving order: " + ex.getMessage(), ex);
        }
    }

    public void update(Order order) {
        String sql = "UPDATE orders SET"
                + " orderId = ?,"
                + " type = ?,"
                + " description = ?,"
                + " status = ?,"
                + " createdAt = ?,"
                + " updatedAt = ?"
                + " WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getType());
            statement.setString(3, order.getDescription());
            statement.setString(4, order.getStatus());
            statement.setDate(5, new java.sql.Date(order.getCreatedAt().getTime()));
            statement.setDate(6, new java.sql.Date(order.getUpdatedAt().getTime()));
            statement.setInt(7, order.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while updating order: " + ex.getMessage(), ex);
        }
    }

    public void removeById(int orderId) {
        String sql = "DELETE FROM orders WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while deleting order: " + ex.getMessage(), ex);
        }
    }

    public List<Order> getAll(int orderId) {
        String sql = "SELECT * FROM orders WHERE orderId = ?";
        
        List<Order> orders = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    Order order = new Order();
                    order.setId(result.getInt("id"));
                    order.setOrderId(result.getInt("orderId"));
                    order.setType(result.getString("type"));
                    // Set other properties here
                    orders.add(order);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error while retrieving orders: " + ex.getMessage(), ex);
        }

        return orders;
    }
}
