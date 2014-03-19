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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InventoryService {

    private String databaseUrlEep;
    private String databaseUrlLeaf;

    public InventoryService(String host, int port) {
        databaseUrlEep = String.format("jdbc:mysql://%s:%d/inventory", host, port);
        databaseUrlLeaf = String.format("jdbc:mysql://%s:%d/leaftech", host, port);
    }

    private Product GetProduct(String Type, String Id, String sourceURL) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String type = Type;
        String id = Id;

        try {
            DBConn = DriverManager.getConnection(sourceURL, "remote", "remote_pass");

        } catch (Exception e) {
            errString = "\nProblem connecting to database(" + sourceURL + "):: " + e;
            throw new SQLException(errString);
        } // end try-catch

        // If we are connected, then we get the product from the
        // inventory database
        try {
            s = DBConn.createStatement();
            res = s.executeQuery("SELECT * FROM " + type + " WHERE productid = '" + id + "';"); /*Was hoping this selected a product with id*/

            // Make sure we got back at least one row
            if (!res.first()) {
                return null;
            }
            return new Product(Id, Type, res.getString("productdescription"),
                    res.getFloat("productprice"), res.getInt("productquantity"));

            /*Now I am thinking of just getting the product*/
            /*
             res.getString(1) /*Copied the below from Orders NewJFrame, don't know what this means...*/
            /*
             while (res.next()) {

             msgString = res.getString(1) + " : " + res.getString(2)
             + " : $" + res.getString(4) + " : " + res.getString(3)
             + " units in stock";
             */
        } catch (SQLException e) {
            errString = "\nProblem getting product from inventory(" + sourceURL + "):: " + e;
            throw new SQLException(errString);

        } // end try-catch

    }

    public Product GetProduct(String Type, String Id) throws SQLException {
        SQLException exception = null;
        Product result;
        try {
            result = GetProduct(Type, Id, this.databaseUrlLeaf);
            if (result != null) {
                return result;
            }
        } catch (SQLException e) {
            exception = e;
        }
        try {
            result = GetProduct(Type, Id, this.databaseUrlEep);
            if (result != null) {
                return result;
            }
        } catch (SQLException e) {
            exception = e;
        }
        if (exception != null) {
            throw exception;
        }
        throw new SQLException("No results found for " + Id + " in " + Type);

    }

    public void AddProduct(Product product) {

    }

    public void DecrementProduct(String Type, int Id) {

    }

    public List<String> GetProductTypes() {
        return null;

    }

    public List<Product> GetProducts(String Type) throws SQLException {
        List<Product> ret = new ArrayList<Product>();
        SQLException exception = null;
        List<Product> result;
        try {
            result = GetProducts(Type, this.databaseUrlLeaf);
            if (result != null) {
                ret.addAll(result);
            }
        } catch (SQLException e) {
            exception = e;
        }
        try {
            result = GetProducts(Type, this.databaseUrlEep);

            if (result != null) {
                ret.addAll(result);
            }
        } catch (SQLException e) {
            exception = e;
        }
        if (ret.size() <= 0 && exception != null) {
            throw exception;
        }
        return ret;

    }

    private List<Product> GetProducts(String Type, String sourceURL) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String type = Type;

        try {
            DBConn = DriverManager.getConnection(sourceURL, "remote", "remote_pass");

        } catch (Exception e) {
            errString = "\nProblem connecting to database(" + sourceURL + "):: " + e;
            throw new SQLException(errString);
        } // end try-catch

        // If we are connected, then we get the product from the
        // inventory database
        try {
            s = DBConn.createStatement();
            res = s.executeQuery("SELECT * FROM " + type + " ;");

            // Make sure we got back at least one row
            if (!res.first()) {
                return null;
            }
            List<Product> return_products = new ArrayList<Product>();
            do {
                return_products.add(new Product(res.getString("productid"), Type, res.getString("productdescription"),
                        res.getFloat("productprice"), res.getInt("productquantity")));
            } while (res.next());
            return return_products;
            /*Now I am thinking of just getting the product*/
            /*
             res.getString(1) /*Copied the below from Orders NewJFrame, don't know what this means...*/
            /*
             while (res.next()) {

             msgString = res.getString(1) + " : " + res.getString(2)
             + " : $" + res.getString(4) + " : " + res.getString(3)
             + " units in stock";
             */
        } catch (SQLException e) {
            errString = "\nProblem getting product from inventory(" + sourceURL + "):: " + e;
            throw new SQLException(errString);

        } // end try-catch

    }

}
