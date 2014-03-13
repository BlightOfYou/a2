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

}
