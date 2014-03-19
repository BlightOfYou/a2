/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Product;
import java.sql.SQLException;
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
public class InventoryServiceTest {
    
    public InventoryServiceTest() {
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
     * Test of GetProduct method, of class InventoryService.
     */
    @Test
    public void testGetProduct() throws SQLException {
        System.out.println("GetProduct");
        String Type = "cultureboxes";
        String Id = "PB005";
        InventoryService instance = new InventoryService("localhost",3306);
        Product expResult = new Product(Id,Type,"B-Cap",(float)250.00,45);
        Product result = instance.GetProduct(Type, Id);
        assertNotNull(result);
        assertTrue(expResult.equals(result));
        assertEquals(expResult,(result));
        
        
    }

    /**
     * Test of AddProduct method, of class InventoryService.
     */
    @Test
    @Ignore
    public void testAddProduct() {
        System.out.println("AddProduct");
        Product product = null;
        InventoryService instance = new InventoryService("localhost",3306);
        instance.AddProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DecrementProduct method, of class InventoryService.
     */
    @Test
    @Ignore
    public void testDecrementProduct() {
        System.out.println("DecrementProduct");
        String Type = "";
        int Id = 0;
        InventoryService instance = new InventoryService("localhost",3306);
        instance.DecrementProduct(Type, Id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetProductTypes method, of class InventoryService.
     */
    @Test
    @Ignore
    public void testGetProductTypes() {
        System.out.println("GetProductTypes");
        InventoryService instance = new InventoryService("localhost",3306);
        List<String> expResult = null;
        List<String> result = instance.GetProductTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetProducts method, of class InventoryService.
     */
    @Test
    public void testGetProducts() throws SQLException {
        System.out.println("GetProducts");
        String Type = "cultureboxes";
        InventoryService instance = new InventoryService("localhost",3306);
        List<Product> result = instance.GetProducts(Type);
        assertEquals(7, result.size());
    }
    
}
