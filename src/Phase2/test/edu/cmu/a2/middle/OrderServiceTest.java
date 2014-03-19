/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Order;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SubmitOrder method, of class OrderService.
     */
    @Test
    public void testSubmitOrder() throws SQLException {
        System.out.println("SubmitOrder");
        Order order = null;
        OrderService instance = null;
        instance.SubmitOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetOrder method, of class OrderService.
     */
    @Test
    public void testGetOrder() throws SQLException {
        System.out.println("GetOrder");
        int OrderId = 0;
        OrderService instance = null;
        Order expResult = null;
        Order result = instance.GetOrder(OrderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteOrder method, of class OrderService.
     */
    @Test
    public void testDeleteOrder() {
        System.out.println("DeleteOrder");
        int OrderId = 0;
        OrderService instance = null;
        instance.DeleteOrder(OrderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ShipOrder method, of class OrderService.
     */
    @Test
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
    public void testGetAllOrders() {
        System.out.println("GetAllOrders");
        OrderService instance = null;
        List<Order> expResult = null;
        List<Order> result = instance.GetAllOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetShippedOrders method, of class OrderService.
     */
    @Test
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
