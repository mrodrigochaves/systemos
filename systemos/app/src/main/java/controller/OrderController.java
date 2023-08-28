/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import util.ConnectionFactory;

/**
 *
 * @author Márcio Rodrigo
 */
public class OrderController {

    public void save(Order order) {
        String sql = "INSERT INTO orders(orderId, type, description, status, createdAt, updateAt)"
                + " VALUES (?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getType());
            statement.setString(3, order.getDescription());
            statement.setString(4, order.getStatus());
            statement.setDate(5, new Date(order.getCreatedAt().getTime()));
            statement.setDate(6, new Date(order.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a ordem" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Order order) {
        String sql = "UPDATE orders SET"
                + "orderId = ?,"
                + "type = ?,"
                + "description = ?,"
                + "status = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?,"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getType());
            statement.setString(3, order.getDescription());
            statement.setString(4, order.getStatus());
            statement.setDate(5, new Date(order.getCreatedAt().getTime()));
            statement.setDate(6, new Date(order.getUpdatedAt().getTime()));
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a ordem" + ex.getMessage(), ex);
        }
    }

    public void removeById(int orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE id =?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a ordem");
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Order> getAll(Long orderId) {
        
        String sql = "SELECT * FROM orders WHERE orderId = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Order> orders = new ArrayList<Order>[];
        
        try{
        connection = ConnectionFactory.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, orderId);
        result = statement.executeQuery();
        
        while(result.next()){
            Order order = new Order();
            order.setId(result.getInt("id"));
            order.setOrderId(result.getInt("orderId"));
            order.setType(result.getString("type"));
        }
        }catch(Exception ex){
                
                }
        
        
        return null;
    }
}
