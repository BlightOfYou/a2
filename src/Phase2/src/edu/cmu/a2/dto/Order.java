/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.OrderId;
        hash = 53 * hash + Objects.hashCode(this.OrderDate);
        hash = 53 * hash + Objects.hashCode(this.FirstName);
        hash = 53 * hash + Objects.hashCode(this.LastName);
        hash = 53 * hash + Objects.hashCode(this.Address);
        hash = 53 * hash + Objects.hashCode(this.Phone);
        hash = 53 * hash + Float.floatToIntBits(this.TotalCost);
        hash = 53 * hash + (this.Shipped ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.OrderItems);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.OrderId != other.OrderId) {
            return false;
        }
        /*
         if (!Objects.equals(this.OrderDate, other.OrderDate)) {
         return false;
         }
         */
        if (!Objects.equals(this.FirstName, other.FirstName)) {
            return false;
        }
        if (!Objects.equals(this.LastName, other.LastName)) {
            return false;
        }
        if (!Objects.equals(this.Address, other.Address)) {
            return false;
        }
        if (!Objects.equals(this.Phone, other.Phone)) {
            return false;
        }
        if (Float.floatToIntBits(this.TotalCost) != Float.floatToIntBits(other.TotalCost)) {
            return false;
        }
        if (this.Shipped != other.Shipped) {
            return false;
        }
        /*
         if (!Objects.equals(this.OrderItems, other.OrderItems)) {
         return false;
         }
         */
        return true;
    }

    @Override
    public String toString() {
        return ">>" + OrderId + "::" +
                OrderDate + "::" + 
                FirstName + "::" + 
                LastName + "::" + 
                Address + "::" + 
                Phone + "::" + 
                TotalCost + "::" + 
                Shipped + "::" + 
                Arrays.toString(OrderItems.toArray());
        //"Order{" + "OrderId=" + OrderId + ", OrderDate=" + OrderDate + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + ", Phone=" + Phone + ", TotalCost=" + TotalCost + ", Shipped=" + Shipped + ", OrderItems=" + OrderItems + '}';
    }

}
