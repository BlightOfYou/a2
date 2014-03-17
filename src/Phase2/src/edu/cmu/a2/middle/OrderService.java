/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Order;
import java.util.List;

/**
 *
 */
public class OrderService {

    public OrderService(String DatabaseUrl) {
    }

    public void SubmitOrder(Order order) {

    }

    public Order GetOrder(int OrderId) {
        return null;
    }

    public void DeleteOrder(int OrderId) {
    }

    public void ShipOrder(int OrderId) {
    }

    public List<Order> GetAllOrders() {
        return null;
    }

    public List<Order> GetShippedOrders() {
        return null;
    }

    public List<Order> GetPendingOrders() {
        return null;
    }
}
