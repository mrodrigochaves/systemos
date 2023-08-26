/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.Order;

/**
 *
 * @author Márcio Rodrigo
 */
public class OrderController {
    
    public void save(Order order){}
    
    public void update (Order order){}
    
    public void removeById (Long orderId){
        String sql = "DELETE FROM order WHERE id =?";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
        }catch(Exception e) {
        }
    }
    
    public List<Order> getAll(Long orderId){
        return null;
    }
}
