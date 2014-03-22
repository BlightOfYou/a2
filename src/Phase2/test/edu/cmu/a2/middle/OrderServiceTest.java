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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private int size = 0;

    public OrderServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public int getLastOrder(OrderService instance) throws SQLException {
        int id = 1;
        try {
            for (Order o : instance.GetAllOrders()) {
                if (o.getOrderId() >= id) {
                    id = o.getOrderId();
                }
            }
            return id;
        } catch (Exception e) {
        }
        return id;

    }

    @Before
    public void setUp() {
        OrderService instance = new OrderService("localhost", 3306);
        int OrderId = 1;
        try {
            for (Order o : instance.GetAllOrders()) {
                if (o.getOrderId() >= OrderId) {
                    OrderId = o.getOrderId() + 1;
                }
                this.size++;
            }
        } catch (Exception ex) {
            //Logger.getLogger(OrderServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        String OrderDate = "now"; //varchar(30)
        String FirstName = "A"; //varchar(20)
        String LastName = "b"; //varchar(20)
        String Address = "C"; //varchar(80)
        String Phone = "D"; //varchar(15)
        float TotalCost = 1; //float(10,2)
        boolean Shipped = false; //tinyint(1)
        List<OrderItem> OrderItems = new ArrayList<OrderItem>(); //varchar(40)
        OrderItems.add(new OrderItem(12, "a", "b", 0));
        order = new Order(OrderId, OrderDate, FirstName, LastName,
                Address, Phone, TotalCost, Shipped, OrderItems);
    }
    Order order;

    @After
    public void tearDown() {
        OrderService instance = new OrderService("localhost", 3306);
        try {
            while (instance.GetAllOrders().size() > this.size) {
                instance.DeleteOrder(getLastOrder(instance));

            }
        } catch (Exception ex) {
            //Oh well, I tried
        }
    }

    /**
     * Test of SubmitOrder method, of class OrderService.
     */
    @Test
    public void testSubmitOrder() throws SQLException {
        System.out.println("SubmitOrder");
        OrderService instance = new OrderService("localhost", 3306);
        instance.SubmitOrder(order);
        Order result = instance.GetOrder((getLastOrder(instance)));
        order.setOrderId((getLastOrder(instance)));
        assertEquals(order, result);
        instance.DeleteOrder(getLastOrder(instance));

    }

    /**
     * Test of GetOrder method, of class OrderService.
     */
    @Test
    public void testGetOrder() throws SQLException {
        System.out.println("GetOrder");
        OrderService instance = new OrderService("localhost", 3306);
        Order expResult = order;

        instance.SubmitOrder(order);
        order.setOrderId(getLastOrder(instance));
        Order result = instance.GetOrder((getLastOrder(instance)));
        assertNotNull(result);
        assertEquals(expResult, result);

        instance.DeleteOrder(getLastOrder(instance));
    }

    /**
     * Test of DeleteOrder method, of class OrderService.
     */
    @Test
    public void testDeleteOrder() throws SQLException {
        System.out.println("DeleteOrder");
        int OrderId = order.getOrderId();
        OrderService instance = new OrderService("localhost", 3306);
        instance.SubmitOrder(order);
        int expected = instance.GetAllOrders().size() - 1;
        instance.DeleteOrder(getLastOrder(instance));

        int actual = 0;
        try {
            instance.GetAllOrders().size();
        } catch (Exception e) {
            //no orders left
        }

        assertEquals(expected, actual);
    }

    /**
     * Test of ShipOrder method, of class OrderService.
     */
    @Test
    public void testShipOrder() throws SQLException {
        System.out.println("ShipOrder");
        OrderService instance = new OrderService("localhost", 3306);
        order.setShipped(true);
        instance.SubmitOrder(order);
        order.setOrderId(this.getLastOrder(instance));
        instance.ShipOrder(order.getOrderId());

        Order actual = instance.GetOrder(order.getOrderId());
        assertTrue(actual.isShipped());
        instance.DeleteOrder(getLastOrder(instance));
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
        instance.DeleteOrder(getLastOrder(instance));
    }

    /**
     * Test of GetShippedOrders method, of class OrderService.
     */
    @Test
    public void testGetShippedOrders() throws SQLException {
        System.out.println("GetShippedOrders");
        OrderService instance = new OrderService("localhost", 3306);
        order.setShipped(true);
        instance.SubmitOrder(order);
        order.setOrderId(this.getLastOrder(instance));
        instance.ShipOrder(order.getOrderId());

        List<Order> result = instance.GetShippedOrders();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        Order actual = instance.GetOrder(order.getOrderId());
        assertTrue(actual.isShipped());
        instance.DeleteOrder(getLastOrder(instance));

    }

    /**
     * Test of GetPendingOrders method, of class OrderService.
     */
    @Test
    public void testGetPendingOrders() throws SQLException {
        System.out.println("GetPendingOrders");
        OrderService instance = new OrderService("localhost", 3306);
        order.setShipped(false);
        instance.SubmitOrder(order);
        List<Order> result = instance.GetPendingOrders();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        Order actual = instance.GetOrder(this.getLastOrder(instance));
        assertFalse(actual.isShipped());
        instance.DeleteOrder(getLastOrder(instance));

    }

}
