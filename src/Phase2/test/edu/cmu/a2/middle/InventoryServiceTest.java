/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Product;
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
    public void testGetProduct() {
        System.out.println("GetProduct");
        String Type = "";
        int Id = 0;
        InventoryService instance = null;
        Product expResult = null;
        Product result = instance.GetProduct(Type, Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddProduct method, of class InventoryService.
     */
    @Test
    public void testAddProduct() {
        System.out.println("AddProduct");
        Product product = null;
        InventoryService instance = null;
        instance.AddProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DecrementProduct method, of class InventoryService.
     */
    @Test
    public void testDecrementProduct() {
        System.out.println("DecrementProduct");
        String Type = "";
        int Id = 0;
        InventoryService instance = null;
        instance.DecrementProduct(Type, Id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetProductTypes method, of class InventoryService.
     */
    @Test
    public void testGetProductTypes() {
        System.out.println("GetProductTypes");
        InventoryService instance = null;
        List<ProcessBuilder.Redirect.Type> expResult = null;
        List<ProcessBuilder.Redirect.Type> result = instance.GetProductTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetProducts method, of class InventoryService.
     */
    @Test
    public void testGetProducts() {
        System.out.println("GetProducts");
        String Type = "";
        InventoryService instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.GetProducts(Type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
