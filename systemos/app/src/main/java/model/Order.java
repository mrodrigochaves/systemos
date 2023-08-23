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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate_request() {
        return date_request;
    }

    public void setDate_request(Date date_request) {
        this.date_request = date_request;
    }

    public Date getDate_status() {
        return date_status;
    }

    public void setDate_status(Date date_status) {
        this.date_status = date_status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", type=" + type + ", description=" + description + ", status=" + status + ", date_request=" + date_request + ", date_status=" + date_status + '}';
    }
    
}
