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
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class OrderService {

    private String databaseUrl;

    public OrderService(String host, int port) {
        databaseUrl = String.format("jdbc:mysql://%s:%d/orders", host, port);
        ;
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
        Connection DBConn = null;
        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");

            /*SQL command to select a single order from the SQL database*/
            Statement s = DBConn.createStatement();
            String SQLStatement = ("SELECT * FROM orders WHERE order_id = " + Integer.toString(OrderId) + "");
            ResultSet res = s.executeQuery(SQLStatement);

        }//try
        catch (SQLException e) {
            String errString = "\nError connecting to orderinfo database\n" + e;

            throw new SQLException(errString);

        }

        return null;
    }

    public void DeleteOrder(int OrderId) {
    }

    public void ShipOrder(int OrderId) {
    }

    public List<Order> GetAllOrders() {
        return null;
    }

    public List<Order> GetShippedOrders() {
        return null;
    }

    public List<Order> GetPendingOrders() {
        return null;
    }
}
