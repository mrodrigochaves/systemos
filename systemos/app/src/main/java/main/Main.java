/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.OrderController;
import model.Order;

/**
 *
 * @author Márcio Rodrigo
 */
public class Main {
    
    public static void main(String[]args){
    
        OrderController orderController = new OrderController();
        
        Order order = new Order();
        order.setItem("Urgente");
        order.setDescription("Problema em computador.");
        order.setStatus("Aberta");
        //orderController.save(order);
        
        order.setId(1);
        order.setOrderId(1);
        order.setStatus("Fechada");
        
        orderController.update(order);
    }
}
