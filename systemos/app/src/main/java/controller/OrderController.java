/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Order;
import util.ConnectionFactory;
/**
 *
 * @author Márcio Rodrigo
 */
public class OrderController {
    
    public void save(Order order){
    String sql = "INSERT INTO order(orderId, name, description)"
            + " VALUES (?,?,?)";
    
    Connection connection = null;
    PreparedStatement statement = null;
    
    try { 
        connection = ConnectionFactory.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, order.getOrderId());
        statement.setString(2, order.getType());
        }catch (Exception e){
    }
    
    public void update (Order order){}
    
    public void removeById (int orderId) throws SQLException{
        String sql = "DELETE FROM order WHERE id =?";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, orderId);
            statement.execute();           
            
        }catch(SQLException e) {
            throw new SQLException("Erro ao deletar a ordem");
        } finally {
        ConnectionFactory.closeConnection(conn);
        }
    }
    
    public List<Order> getAll(Long orderId){
        return null;
    }
}
