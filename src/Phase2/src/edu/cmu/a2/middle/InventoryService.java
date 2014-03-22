/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Product;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
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

    private String getIdentifier(String sourceURL) {
        if (sourceURL.equals(this.databaseUrlEep)) {
            return "product_code";
        } else {
            return "productid";
        }
    }

    private String getDescription(String sourceURL) {
        if (sourceURL.equals(this.databaseUrlEep)) {
            return "description";
        } else {
            return "productdescription";
        }
    }

    private String getQuantity(String sourceURL) {
        if (sourceURL.equals(this.databaseUrlEep)) {
            return "quantity";
        } else {
            return "productquantity";
        }
    }

    private String getPrice(String sourceURL) {
        if (sourceURL.equals(this.databaseUrlEep)) {
            return "price";
        } else {
            return "productprice";
        }
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
            res = s.executeQuery("SELECT * FROM " + type + " WHERE " + getIdentifier(sourceURL) + " = '" + id + "';"); /*Was hoping this selected a product with id*/

            // Make sure we got back at least one row
            if (!res.first()) {
                return null;
            }
            return new Product(Id, Type, res.getString(getDescription(sourceURL)),
                    res.getFloat(getPrice(sourceURL)), res.getInt(getQuantity(sourceURL)));

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

    private String getCorrectUrlForType(String type) throws SQLException {
        List<String> result = GetProductTypes(this.databaseUrlEep);
        HashSet<String> types = new HashSet<String>(result);
        if (types.contains(type)) {
            return this.databaseUrlEep;
        }
        result = GetProductTypes(this.databaseUrlLeaf);
        types = new HashSet<String>(result);
        if (types.contains(type)) {
            return this.databaseUrlLeaf;
        }
        return null;

    }

    public void DeleteProduct(String Type, String Id) throws SQLException, IllegalArgumentException {
        DeleteProduct(new Product(Id, Type, null, 0, 0));
    }

    private void DeleteProduct(Product product) throws SQLException, IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }
        String sourceUrl = getCorrectUrlForType(product.getType());
        if (sourceUrl == null) {
            throw new IllegalArgumentException("Type " + product.getType() + " not found in database");
        }
        DeleteProduct(product, sourceUrl);

    }

    private void DeleteProduct(Product product, String sourceURL) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        int res = -1;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String type = product.getType();
        String id = product.getId();

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
            res = s.executeUpdate(
                    "DELETE FROM " + type
                    + " WHERE " + getIdentifier(sourceURL) + " = "
                    + "'" + product.getId() + "'"
                    + ";"
            );

        } catch (SQLException e) {
            errString = "\nProblem getting product from inventory(" + sourceURL + "):: " + e;
            throw new SQLException(errString);

        } // end try-catch

    }

    public void AddProduct(Product product) throws SQLException, IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }
        String sourceUrl = getCorrectUrlForType(product.getType());
        if (sourceUrl == null) {
            throw new IllegalArgumentException("Type " + product.getType() + " not found in database");
        }
        AddProduct(product, sourceUrl);

    }

    private void AddProduct(Product product, String sourceURL) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        int res = -1;               // SQL query result set pointer
        PreparedStatement s = null;                 // SQL statement pointer
        String type = product.getType();
        String id = product.getId();

        try {
            DBConn = DriverManager.getConnection(sourceURL, "remote", "remote_pass");

        } catch (Exception e) {
            errString = "\nProblem connecting to database(" + sourceURL + "):: " + e;
            throw new SQLException(errString);
        } // end try-catch

        // If we are connected, then we get the product from the
        // inventory database
        try {
            String sql = "INSERT INTO " + type
                            + " (" + getIdentifier(sourceURL) +
                                    ","+getDescription(sourceURL)+
                                    ","+getQuantity(sourceURL)+
                                    ","+getPrice(sourceURL)+") "
                            + "VALUES (?, ?, ?, ?);";
               
            s = DBConn.prepareStatement(sql);
            s.setString(1, product.getId());
            s.setString(2, product.getDescription());
            s.setInt(3, product.getQuantity());
            s.setFloat(4, product.getPrice());
            
            res = s.executeUpdate();
            
        } catch (SQLException e) {
            errString = "\nProblem getting product from inventory(" + sourceURL + "):: " + e;
            throw new SQLException(errString);

        } // end try-catch

    }

    public void DecrementProduct(String Type, String Id) throws SQLException {
        SQLException exception = null;
        //lazy way of determining if it exists
        Product result = this.GetProduct(Type, Id);
        try {
            DecrementProduct(result, this.databaseUrlEep);
            return;
        } catch (SQLException e) {
            exception = e;
        }
        try {
            DecrementProduct(result, this.databaseUrlLeaf);
            return;
        } catch (SQLException e) {
            exception = e;
        }
        if (exception != null) {
            throw exception;
        }
    }

    private void DecrementProduct(Product product, String sourceURL) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        int res = -1;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String type = product.getType();
        String id = product.getId();

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
            res = s.executeUpdate("UPDATE " + type + 
                    " SET "+getQuantity(sourceURL)+"="+getQuantity(sourceURL)+
                    "-1 WHERE " + getIdentifier(sourceURL) + "='" + id + "';"); /*Was hoping this selected a product with id*/

        } catch (SQLException e) {
            errString = "\nProblem getting product from inventory(" + sourceURL + "):: " + e;
            throw new SQLException(errString);

        } // end try-catch

    }

    public List<String> GetProductTypes() throws SQLException {
        List<String> ret = new ArrayList<String>();
        List<String> result;
        result = GetProductTypes(this.databaseUrlEep);
        if (result != null) {
            ret.addAll(result);
        }
        result = GetProductTypes(this.databaseUrlLeaf);
        if (result != null) {
            ret.addAll(result);
        }
        return ret;

    }

    private List<String> GetProductTypes(String sourceURL) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer

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
            res = s.executeQuery("SHOW TABLES ;");

            // Make sure we got back at least one row
            if (!res.first()) {
                return null;
            }
            List<String> return_products = new ArrayList<String>();
            do {
                String type = res.getString(1);
                if (type != null && !type.equals("")) {
                    return_products.add(type);
                }
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
                return_products.add(new Product(res.getString(getIdentifier(sourceURL)), Type, res.getString(getDescription(sourceURL)),
                        res.getFloat(getPrice(sourceURL)), res.getInt(getQuantity(sourceURL))));
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
