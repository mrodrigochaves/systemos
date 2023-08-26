/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Márcio Rodrigo
 */
public class ConectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/systemosdb";
    public static final String USER = "admin";
    public static final String PASS = "123456";

    /**
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro de conecxão com banco de dados", ex);
        }

    }
    
    public static void closeConnection(Connection connection){
    try {
    if(connection != null){
        connection.close();
    }
    } catch(Exception ex){
    throw new RuntimeException("Erro ao fechar conexão com banco de dados")
    }
    }
}
