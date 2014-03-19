/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Product;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 */
public class InventoryService {

    public InventoryService(String host, int port) {
             
    }

    public Product GetProduct(String Type, int Id) {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String type = Type;
        int id = Id;
        
        try {
            DBConn = DriverManager.getConnection(sourceURL,"remote","remote_pass");
            
            Statem
        } catch (Exception e) {
            errString =  "\nProblem connecting to database:: " + e;
            connectError = true;
        } // end try-catch
        
        
        // If we are connected, then we get the product from the
        // inventory database
        
        if ( !connectError )
        {
            try
            {
                s = DBConn.createStatement();
                res = s.executeQuery( "SELECT * FROM inventory WHERE product = "+ id +";" ); /*Was hoping this selected a product with id*/

                /*Now I am thinking of just getting the product*/
                res.getString(1)
                
                /*Copied the below from Orders NewJFrame, don't know what this means...*/        
                while (res.next())
                {
                    
                    msgString = res.getString(1) + " : " + res.getString(2) +
                            " : $"+ res.getString(4) + " : " + res.getString(3)
                            + " units in stock";

                } // while
                
            } catch (Exception e) {

                errString =  "\nProblem getting product from inventory:: " + e;

            } // end try-catch
        } // if connect check
        return null;

    }

    public void AddProduct(Product product) {

    }

    public void DecrementProduct(String Type, int Id) {

    }

    public List<Type> GetProductTypes() {
        return null;

    }

    public List<Product> GetProducts(String Type) {
        return null;

    }
}
