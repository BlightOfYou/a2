/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.dto;

import java.util.List;

/**
 *
 */
public class Order {

    public int OrderId;
    public String OrderDate; //varchar(30)
    public String FirstName; //varchar(20)
    public String LastName; //varchar(20)
    public String Address; //varchar(80)
    public String Phone; //varchar(15)
    public float TotalCost; //float(10,2)
    public boolean Shipped; //tinyint(1)
    public List<OrderItem> OrderItems; //varchar(40)

    public Order(int OrderId, String OrderDate, String FirstName, String LastName, String Address, String Phone, float TotalCost, boolean Shipped, List<OrderItem> OrderItems) {
        this.OrderId = OrderId;
        this.OrderDate = OrderDate;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.Phone = Phone;
        this.TotalCost = TotalCost;
        this.Shipped = Shipped;
        this.OrderItems = OrderItems;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public float getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(float TotalCost) {
        this.TotalCost = TotalCost;
    }

    public boolean isShipped() {
        return Shipped;
    }

    public void setShipped(boolean Shipped) {
        this.Shipped = Shipped;
    }

    public List<OrderItem> getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(List<OrderItem> OrderItems) {
        this.OrderItems = OrderItems;
    }

    
    
}
