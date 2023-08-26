/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OS;

import java.sql.Connection;
import util.ConnectionFactory;

/**
 *
 * @author Márcio Rodrigo
 */
public class Main {
    
    public static void main(String[] args){
    Connection c = ConnectionFactory.getConnection();
    
    ConnectionFactory.closeConnection(c);
    
    }
    
}
