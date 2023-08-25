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
    private Date createdDate;
    private Date statusDate;

    public Order(Long id, String type, String description, String status, Date createdDate, Date statusDate) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        this.statusDate = statusDate;
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", type=" + type + ", description=" + description + ", status=" + status + ", createdDate=" + createdDate + ", statusDate=" + statusDate + '}';
    }

}
