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
    public void testAddProduct() throws SQLException {
        System.out.println("AddProduct");
        Product product = new Product(("P"+Math.random()).substring(0, 10),"cultureboxes","Desc",10f,10);
        InventoryService instance = new InventoryService("localhost",3306);
        instance.AddProduct(product);
        Product actual = instance.GetProduct(product.getType(),product.getId());
        instance.DeleteProduct(product.getType(),product.getId());
        assertEquals(product,actual);
        
    }

    /**
     * Test of DecrementProduct method, of class InventoryService.
     */
    @Test
    public void testDecrementProduct() throws SQLException {
        System.out.println("DecrementProduct");
        Product product = new Product(("P"+Math.random()).substring(0, 10),"cultureboxes","Desc",10f,10);
        InventoryService instance = new InventoryService("localhost",3306);
        instance.AddProduct(product);
        instance.DecrementProduct(product.getType(), product.getId());
        Product actual = instance.GetProduct(product.getType(), product.getId());
        assertEquals(product.getQuantity()-1,actual.getQuantity());
        instance.DeleteProduct(product.getType(),product.getId());

    }

    /**
     * Test of GetProductTypes method, of class InventoryService.
     */
    @Test
    public void testGetProductTypes() throws SQLException {
        System.out.println("GetProductTypes");
        InventoryService instance = new InventoryService("localhost",3306);
        //List<String> expResult = null;
        List<String> result = instance.GetProductTypes();
        assertNotNull(result);
        //Might not be 7 if new tables have been added
        assertEquals(7, result.size());
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
        //Might not be 7 if new tables have been added
        //assertEquals(7, result.size());
        assertFalse(result.isEmpty());
    }
    
}
