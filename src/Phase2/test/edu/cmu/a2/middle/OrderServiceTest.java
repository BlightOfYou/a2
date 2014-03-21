/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Order;
import edu.cmu.a2.dto.OrderItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Dantarp
 */
public class OrderServiceTest {

    public OrderServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        int OrderId = 100;
        String OrderDate = "now"; //varchar(30)
        String FirstName = "A"; //varchar(20)
        String LastName = "b"; //varchar(20)
        String Address = "C"; //varchar(80)
        String Phone = "D"; //varchar(15)
        float TotalCost = 1; //float(10,2)
        boolean Shipped = false; //tinyint(1)
        List<OrderItem> OrderItems = new ArrayList<OrderItem>(); //varchar(40)
        OrderItems.add(new OrderItem(12, 0, 0, 0));
        order = new Order(OrderId, OrderDate, FirstName, LastName,
                Address, Phone, TotalCost, Shipped, OrderItems);
    }
    Order order;

    @After
    public void tearDown() {
    }

    /**
     * Test of SubmitOrder method, of class OrderService.
     */
    @Test
    public void testSubmitOrder() throws SQLException {
        System.out.println("SubmitOrder");
        OrderService instance = new OrderService("localhost", 3306);
        instance.SubmitOrder(order);
        Order result = instance.GetOrder(order.getOrderId());
        assertEquals(order, result);
        instance.DeleteOrder(order.getOrderId());

    }

    /**
     * Test of GetOrder method, of class OrderService.
     */
    @Test
    public void testGetOrder() throws SQLException {
        System.out.println("GetOrder");
        int OrderId = order.getOrderId();
        OrderService instance = new OrderService("localhost",3306);
        Order expResult = order;

        instance.SubmitOrder(order);
        Order result = instance.GetOrder(OrderId);
        assertEquals(expResult, result);

        instance.DeleteOrder(OrderId);
    }

    /**
     * Test of DeleteOrder method, of class OrderService.
     */
    @Test
    public void testDeleteOrder() throws SQLException {
        System.out.println("DeleteOrder");
        int OrderId = order.getOrderId();
        OrderService instance = new OrderService("localhost",3306);
        instance.SubmitOrder(order);
        instance.DeleteOrder(OrderId);
    }

    /**
     * Test of ShipOrder method, of class OrderService.
     */
    @Test
    @Ignore
    public void testShipOrder() {
        System.out.println("ShipOrder");
        int OrderId = 0;
        OrderService instance = null;
        instance.ShipOrder(OrderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllOrders method, of class OrderService.
     */
    @Test
    public void testGetAllOrders() throws SQLException {
        System.out.println("GetAllOrders");

        OrderService instance = new OrderService("localhost", 3306);
        instance.SubmitOrder(order);

        //List<Order> expResult = null;
        List<Order> result = instance.GetAllOrders();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(result);
        assertFalse(result.isEmpty());

        instance.DeleteOrder(order.getOrderId());
    }

    /**
     * Test of GetShippedOrders method, of class OrderService.
     */
    @Test
    @Ignore
    public void testGetShippedOrders() {
        System.out.println("GetShippedOrders");
        OrderService instance = null;
        List<Order> expResult = null;
        List<Order> result = instance.GetShippedOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPendingOrders method, of class OrderService.
     */
    @Test
    @Ignore
    public void testGetPendingOrders() {
        System.out.println("GetPendingOrders");
        OrderService instance = null;
        List<Order> expResult = null;
        List<Order> result = instance.GetPendingOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
