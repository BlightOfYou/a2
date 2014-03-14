/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cmu.a2.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Dantarp
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({edu.cmu.a2.ui.InventoryMainFrameTest.class, edu.cmu.a2.ui.ShippingMainFrameTest.class, edu.cmu.a2.ui.LoginFrameTest.class, edu.cmu.a2.ui.OrderMainFrameTest.class})
public class UiSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
