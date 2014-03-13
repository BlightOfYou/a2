/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Session;
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
public class LoginServiceTest {
    
    public LoginServiceTest() {
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
     * Test of Login method, of class LoginService.
     */
    @Test
    public void testLogin() {
        System.out.println("Login");
        String Username = "";
        String Password = "";
        LoginService instance = null;
        Session expResult = null;
        Session result = instance.Login(Username, Password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Logout method, of class LoginService.
     */
    @Test
    public void testLogout() {
        System.out.println("Logout");
        Session session = null;
        LoginService instance = null;
        instance.Logout(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
