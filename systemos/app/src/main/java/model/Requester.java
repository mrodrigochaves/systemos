/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sula
 */
public class Requester {
 
    private Long id;
    private String name;
    private String orderType;
    private String orderDescription;
    private String orderStatus;
    private String orderUpdate;

    public Requester(Long id, String name, String orderType, String orderDescription, String orderStatus, String orderUpdate) {
        this.id = id;
        this.name = name;
        this.orderType = orderType;
        this.orderDescription = orderDescription;
        this.orderStatus = orderStatus;
        this.orderUpdate = orderUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderUpdate() {
        return orderUpdate;
    }

    public void setOrderUpdate(String orderUpdate) {
        this.orderUpdate = orderUpdate;
    }

    @Override
    public String toString() {
        return "Requester{" + "id=" + id + ", name=" + name + ", orderType=" + orderType + ", orderDescription=" + orderDescription + ", orderStatus=" + orderStatus + ", orderUpdate=" + orderUpdate + '}';
    }
    
}
