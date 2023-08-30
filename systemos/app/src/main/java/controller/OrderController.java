package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import util.ConnectionFactory;

public class OrderController {

    public void save(Order order) {
        String sql = "INSERT INTO orders(orderId, type, description, status, createdAt, updatedAt)"
                + " VALUES (?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getType());
            statement.setString(3, order.getDescription());
            statement.setString(4, order.getStatus());

            java.util.Date createdAt = order.getCreatedAt();
            if (createdAt != null) {
                statement.setDate(5, new java.sql.Date(createdAt.getTime()));
            } else {
                statement.setNull(5, java.sql.Types.DATE);
            }

            java.util.Date updatedAt = order.getUpdatedAt();
            if (updatedAt != null) {
                statement.setDate(6, new java.sql.Date(updatedAt.getTime()));
            } else {
                statement.setNull(6, java.sql.Types.DATE);
            }

            statement.executeUpdate();

        } catch (Exception ex) {
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

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getType());
            statement.setString(3, order.getDescription());
            statement.setString(4, order.getStatus());

            java.util.Date createdAt = order.getCreatedAt();
            if (createdAt != null) {
                statement.setDate(5, new java.sql.Date(createdAt.getTime()));
            } else {
                statement.setNull(5, java.sql.Types.DATE);
            }

            java.util.Date updatedAt = order.getUpdatedAt();
            if (updatedAt != null) {
                statement.setDate(6, new java.sql.Date(updatedAt.getTime()));
            } else {
                // Set updatedAt to current timestamp if it's null
                java.util.Date currentTimestamp = new java.util.Date();
                statement.setTimestamp(6, new java.sql.Timestamp(currentTimestamp.getTime()));
            }

            statement.setInt(7, order.getId());
            statement.executeUpdate();

        } catch (Exception ex) {
            throw new RuntimeException("Error while updating order: " + ex.getMessage(), ex);
        }
    }

    public void removeById(int orderId) {
        String sql = "DELETE FROM orders WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            statement.executeUpdate();

        } catch (Exception ex) {
            throw new RuntimeException("Error while deleting order: " + ex.getMessage(), ex);
        }
    }

    public List<Order> getAll(int orderId) {
        String sql = "SELECT * FROM orders WHERE orderId = ?";

        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            result = statement.executeQuery();

            while (result.next()) {
                Order order = new Order();
                order.setId(result.getInt("id"));
                order.setOrderId(result.getInt("orderId"));
                order.setType(result.getString("type"));
                // Set other properties here
                orders.add(order);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error while retrieving orders: " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }

        return orders;
    }
}
