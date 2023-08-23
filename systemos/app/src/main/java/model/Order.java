/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author sula
 */
public class Order {
    
    private Long id;
    private String type;
    private String description;
    private String status;

    public Order(Long id, String type, String description, String status, Date date_request, Date date_status) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.status = status;
        this.date_request = date_request;
        this.date_status = date_status;
    }
    private Date date_request;
    private Date date_status;
}
