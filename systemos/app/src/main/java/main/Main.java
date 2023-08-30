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
        order.setType("Urgente");
        order.setDescription("Problema em computador.");
        order.setStatus("Aberta");
        orderController.save(order);
    }
}
