/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Order;
import edu.cmu.a2.dto.OrderItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class OrderService {

    private String databaseUrl;

    public OrderService(String host, int port) {
        databaseUrl = String.format("jdbc:mysql://%s:%d/orderinfo", host, port);
    }

    public void SubmitOrder(Order order) throws SQLException/*Some kind of exception*/ {
        Connection DBConn = null;
        Boolean executeError = false;   // Error flag
        Boolean connectError = false;   // Error flag
        String errString = null;        // String for displaying errors
        String orderTableName = null;   // This is the name of the table that lists the items
        String SQLstatement = null;     // String for building SQL queries
        int executeUpdateVal;           // Return value from execute indicating effected rows
        Statement s = null;             // SQL statement pointer
        String msgString = null;        // String for displaying non-error messages

        // Check to make sure there is a first name, last name, address and phone
        if ((order.FirstName.length() > 0) && (order.LastName.length() > 0)
                && (order.Address.length() > 0)
                && (order.Phone.length() > 0)) {

            try {

                DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");

            } catch (SQLException e) {
                errString = "\nError connecting to orderinfo database\n" + e;
                /*jTextArea3.append(errString); throws new Exception(errString)?*/
                connectError = true;
                throw new SQLException(errString);
            } // end try-catch
        } else {
            errString = "\nMissing customer information!!!\n";
            /*jTextArea3.append(errString); throws new Exception(errString)?*/
            connectError = true;
            throw new SQLException(errString);

        }// customer data check

        //If there is not a connection error, then we form the SQL statement
        //to submit the order to the orders table and then execute it.
        if (!connectError) {
            Calendar rightNow = Calendar.getInstance();

            int TheHour = rightNow.get(rightNow.HOUR_OF_DAY);
            int TheMinute = rightNow.get(rightNow.MINUTE);
            int TheSecond = rightNow.get(rightNow.SECOND);
            int TheDay = rightNow.get(rightNow.DAY_OF_WEEK);
            int TheMonth = rightNow.get(rightNow.MONTH);
            int TheYear = rightNow.get(rightNow.YEAR);
            orderTableName = "order" + String.valueOf(rightNow.getTimeInMillis());

            String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                    + TheHour + ":" + TheMinute + ":" + TheSecond;

            // Get the order data
            try {
                s = DBConn.createStatement();

                SQLstatement = ("CREATE TABLE " + orderTableName
                        + "(item_id int unsigned not null auto_increment primary key, "
                        + "product_id varchar(20), description varchar(80), "
                        + "item_price float(7,2) );");

                executeUpdateVal = s.executeUpdate(SQLstatement);

            } catch (SQLException e) {

                errString = "\nProblem creating order table " + orderTableName + ":: " + e;
                /*jTextArea3.append(errString); throws new Exception(errString)?*/
                executeError = true;
                throw new SQLException(errString);

            } // try

            if (!executeError) {
                try {
                    SQLstatement = ("INSERT INTO orders (order_date, " + "first_name, "
                            + "last_name, address, phone, total_cost, shipped, "
                            + "ordertable) VALUES ( '" + dateTimeStamp + "', "
                            + "'" + order.FirstName + "', " + "'" + order.LastName + "', "
                            + "'" + order.Address + "', " + "'" + order.Phone + "', "
                            + order.TotalCost + ", " + false + ", '" + orderTableName + "' );");

                    executeUpdateVal = s.executeUpdate(SQLstatement);

                } catch (Exception e1) {

                    errString = "\nProblem with inserting into table orders:: " + e1;
                    /*jTextArea3.append(errString); throws new Exception(errString)?*/
                    executeError = true;

                    try {
                        SQLstatement = ("DROP TABLE " + orderTableName + ";");
                        executeUpdateVal = s.executeUpdate(SQLstatement);

                    } catch (SQLException e2) {

                        errString = "\nProblem deleting unused order table:: "
                                + orderTableName + ":: " + e2;
                        /*jTextArea3.append(errString); throws new Exception(errString)?*/
                        throw new SQLException(errString);

                    } // try

                } // try

            } //execute error check

        }

        // Now, if there is no connect or SQL execution errors at this point, 
        // then we have an order added to the orderinfo::orders table, and a 
        // new ordersXXXX table created. Here we insert the list of items in
        // jTextArea2 into the ordersXXXX table.
        if (!connectError && !executeError) {
            // Now we create a table that contains the itemized list
            // of stuff that is associated with the order
            //OrderItem orderItem = new OrderItem(); /*Don't know if I need to make this for lines 166-168*/
            List<OrderItem> items = order.getOrderItems();
//            for (int i = 0; i < items.size(); i++ )
//            {
//                OrderItem orderItem = items.get(i);
            for (OrderItem item : items) //                jTextArea3.append("\nitem #:" + i + ": " + items[i]);
            // Check just to make sure that a blank line was not stuck in
            // there... just in case.
            {
                if (item != null) {

                    SQLstatement = ("INSERT INTO " + orderTableName
                            + " (product_id, description, item_price) "
                            + "VALUES ( '" + item.getProductId() + "', " + "'"
                            + item.getDescription() + "', " + String.valueOf(item.getItemPrice()) + " );"); /*I don't know why this is showing up as an error*/

                    try {
                        executeUpdateVal = s.executeUpdate(SQLstatement);
                        msgString = "\nORDER SUBMITTED FOR: " + order.FirstName + " " + order.LastName;
                        /*jTextArea3.append(errString); throws new Exception(msgString)?*/

                    } catch (Exception e) {

                        errString = "\nProblem with inserting into table " + orderTableName
                                + ":: " + e;
                        /*jTextArea3.append(errString); throws new Exception(errString)?*/
                        throw new SQLException(errString);

                    } // try

                } // line length check
            }
        } //for each line of text in order table

    }

    public Order GetOrder(int OrderId) throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer 

        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");
        } catch (SQLException e) {
            errString = "\nProblem connecting to database(" + databaseUrl + "):: " + e;
            connectError = true;
            throw new SQLException(errString);
        } // end try-catch

        if (!connectError) {
            try {
                /*SQL command to select a single order from the SQL database*/
                s = DBConn.createStatement();
                res = s.executeQuery("SELECT * FROM orders WHERE order_id = "
                        + Integer.toString(OrderId) + ";");

                if (!res.first()) {
                    return null;
                }
                    String ordertable = (res.getString("ordertable"));
                    s = DBConn.createStatement();
                    ResultSet res2 = s.executeQuery("SELECT * FROM " + ordertable + " ;");
                    List<OrderItem> orders = new ArrayList<OrderItem>();
                    // Make sure we got back at least one row
                    if (res2.first()) {
                        do {
                            int ItemId = res2.getInt(1);
                            String ProductId = res2.getString(2);
                            String Description = res2.getString(3);
                            float ItemPrice = res2.getFloat(4);

                            orders.add(new OrderItem(ItemId, ProductId, Description, ItemPrice));
                        } while (res2.next());
                    }
                /*create return object*/
                Order return_order = new Order(res.getInt("order_id"),
                        res.getString("order_date"),
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("address"),
                        res.getString("phone"),
                        res.getFloat("total_cost"),
                        res.getBoolean("shipped"),
                        orders); /*Don't know what the error is*/

                return return_order;

            } catch (SQLException e) {
                errString = "\nProblem getting order from orders database\n" + e;
                throw new SQLException(errString);
            } //end try-catch

        } else {
            return null;
        } // end if
    }

    public void DeleteOrder(int OrderId) throws SQLException {
        //Database parameters
        Connection DBConn = null;           //MySQL connection handle
        String errString = null;            //String for displaying errors
        ResultSet res = null;               //SQL query result set pointer
        int del = -1;                       //SQL query 
        Statement s = null;                 //SQL statement pointer

        //Connect to orders database
        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");
        } catch (SQLException e) {
            errString = "\nProblem connecting to database(" + databaseUrl + "):: " + e;
            throw new SQLException(errString);
        } // end try-catch

        // If we are connected, then we query to see if OrderID exists in
        // order database for deletion
        try {
            s = DBConn.createStatement();
            res = s.executeQuery("SELECT * FROM orders WHERE order_id = "
                    + Integer.toString(OrderId) + ";");

        } catch (SQLException e) {
            errString = "\nThat Order ID does not exist:: " + e;
            throw new SQLException(errString);
        } // end try-catch

        // Now try to delete order with order id 
        try {
                del = s.executeUpdate("DELETE FROM orders WHERE order_id = "
                        + Integer.toString(OrderId) + ";");
        } catch (SQLException e) {
            errString = "\nProblem deleting order from order database:: " + e;
            throw new SQLException(errString);
        } // end try-catch
    }

    public void ShipOrder(int OrderId) {
    }

    public List<Order> GetAllOrders() throws SQLException {
        // Database parameters
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer  

        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");

        } catch (Exception e) {
            errString = "\nProblem connecting to database(" + databaseUrl + "):: " + e;
            connectError = true;
            throw new SQLException(errString);
        } // end try-catch

        // If we are connected, then we get the orders from the
        // order database
        if (!connectError) {
            try {
                s = DBConn.createStatement();
                res = s.executeQuery("SELECT * FROM orders;");

                // Make sure we got back at least one row
                if (!res.first()) {
                    return null;
                }
                List<Order> return_allorders = new ArrayList<Order>();
                do {
                    String ordertable = (res.getString("ordertable"));
                    s = DBConn.createStatement();
                    ResultSet res2 = s.executeQuery("SELECT * FROM " + ordertable + " ;");
                    List<OrderItem> orders = new ArrayList<OrderItem>();
                    // Make sure we got back at least one row
                    if (res2.first()) {
                        do {
                            int ItemId = res2.getInt(1);
                            String ProductId = res2.getString(2);
                            String Description = res2.getString(3);
                            float ItemPrice = res2.getFloat(4);

                            orders.add(new OrderItem(ItemId, ProductId, Description, ItemPrice));
                        } while (res2.next());
                    }

                    return_allorders.add(new Order(res.getInt("order_id"),
                            res.getString("order_date"),
                            res.getString("first_name"),
                            res.getString("last_name"),
                            res.getString("address"),
                            res.getString("phone"),
                            res.getFloat("total_cost"),
                            res.getBoolean("shipped"),
                            orders)); /*Don't know what the error is*/

                } while (res.next());
                return return_allorders;
            } catch (SQLException e) {
                errString = "\nProblem getting product from inventory(" + databaseUrl + "):: " + e;
                throw new SQLException(errString);

            } // end try-catch
        }
        return null;
    }

    public List<Order> GetShippedOrders() throws SQLException{
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        
        
        // Connect to the order database
        try
        {
            DBConn = DriverManager.getConnection(databaseUrl,"remote","remote_pass");
            
        } catch (Exception e) {
            errString =  "\nProblem connecting to orderinfo database:: " + e;
            connectError = true;
            throw new SQLException(errString);
        }
        
        if ( !connectError )
        {
            try
            {
                // Create a query to get all the orders and execute the query
                s = DBConn.createStatement();
                res = s.executeQuery( "Select * from orders WHERE shipped = 1" );
                
                // Make sure we got back at least one row
                if (!res.first()) {
                    return null;
                }
                List<Order> return_shippedorders = new ArrayList<Order>();
                
                // For each row returned, we check the shipped status. If it is
                // equal to 1 it means it has been shipped.
                do
                {
                    String ordertable = (res.getString("ordertable"));
                    s = DBConn.createStatement();
                    ResultSet res2 = s.executeQuery("SELECT * FROM " + ordertable + " ;");
                    List<OrderItem> orders = new ArrayList<OrderItem>();
                    // Make sure we got back at least one row
                    if (res2.first()) {
                        do {
                            int ItemId = res2.getInt(1);
                            String ProductId = res2.getString(2);
                            String Description = res2.getString(3);
                            float ItemPrice = res2.getFloat(4);

                            orders.add(new OrderItem(ItemId, ProductId, Description, ItemPrice));
                        } while (res2.next());
                    }

                    return_shippedorders.add(new Order(res.getInt("order_id"),
                                                    res.getString("order_date"),
                                                    res.getString("first_name"),
                                                    res.getString("last_name"),
                                                    res.getString("address"),
                                                    res.getString("phone"),
                                                    res.getFloat("total_cost"),
                                                    res.getBoolean("shipped"),
                                                    orders));
                } while (res.next());
                return return_shippedorders;
            } catch (Exception e) {
                errString =  "\nProblem getting shipped orders:: " + e;
                throw new SQLException(errString);
            } // end try-catch
        
        } // if connect check
         
        return null;
    }

    public List<Order> GetPendingOrders() throws SQLException {
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        
        
        // Connect to the order database
        try
        {
            DBConn = DriverManager.getConnection(databaseUrl,"remote","remote_pass");
            
        } catch (Exception e) {
            errString =  "\nProblem connecting to orderinfo database:: " + e;
            connectError = true;
            throw new SQLException(errString);
        }
        
        if ( !connectError )
        {
            try
            {
                // Create a query to get all the orders and execute the query
                s = DBConn.createStatement();
                res = s.executeQuery( "Select * from orders WHERE shipped = 0;" );
                
                // Make sure we got back at least one row
                if (!res.first()) {
                    return null;
                }
                List<Order> return_pendingorders = new ArrayList<Order>();
                
                // For each row returned, we check the shipped status. If it is
                // equal to 0 it means it has not been shipped as of yet.
                do
                {
                    String ordertable = (res.getString("ordertable"));
                    s = DBConn.createStatement();
                    ResultSet res2 = s.executeQuery("SELECT * FROM " + ordertable + " ;");
                    List<OrderItem> orders = new ArrayList<OrderItem>();
                    // Make sure we got back at least one row
                    if (res2.first()) {
                        do {
                            int ItemId = res2.getInt(1);
                            String ProductId = res2.getString(2);
                            String Description = res2.getString(3);
                            float ItemPrice = res2.getFloat(4);

                            orders.add(new OrderItem(ItemId, ProductId, Description, ItemPrice));
                        } while (res2.next());
                    }

                    return_pendingorders.add(new Order(res.getInt("order_id"),
                                                    res.getString("order_date"),
                                                    res.getString("first_name"),
                                                    res.getString("last_name"),
                                                    res.getString("address"),
                                                    res.getString("phone"),
                                                    res.getFloat("total_cost"),
                                                    res.getBoolean("shipped"),
                                                    orders));
                } while (res.next());
                return return_pendingorders;
            } catch (Exception e) {
                errString =  "\nProblem getting pending orders:: " + e;
                throw new SQLException(errString);
            } // end try-catch
        
        } // if connect check
         
        return null;
    }
}
