/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class OrderService {
    
    private String databaseUrl;
    private String firstName;
    private String lastName;
    
    public OrderService(String DatabaseUrl) {
        databaseUrl = DatabaseUrl;
    }

    public void SubmitOrder(Order order) {
        /*MOSTLY COPIED THIS FROM ORDERAPP*/
        //If there is not a connection error, then we form the SQL statement
        //to submit the order to the orders table and then execute it.

        if (!connectError )
        {
            Calendar rightNow = Calendar.getInstance();

            int TheHour = rightNow.get(rightNow.HOUR_OF_DAY);
            int TheMinute = rightNow.get(rightNow.MINUTE);
            int TheSecond = rightNow.get(rightNow.SECOND);
            int TheDay = rightNow.get(rightNow.DAY_OF_WEEK);
            int TheMonth = rightNow.get(rightNow.MONTH);
            int TheYear = rightNow.get(rightNow.YEAR);
            orderTableName = "order" + String.valueOf(rightNow.getTimeInMillis());

            String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                    + TheHour + ":" + TheMinute  + ":" + TheSecond;

            // Get the order data
            firstName = Order.getFirstName(); //A get interface needs to be made for this 
            lastName = Order.getLastName(); 
            phoneNumber = jTextField5.getText();
            customerAddress = jTextArea4.getText();
            sTotalCost = jTextField6.getText();
            beginIndex = 0;
            beginIndex = sTotalCost.indexOf("$",beginIndex)+1;
            sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
            fCost = Float.parseFloat(sTotalCost);
                
            try
            {
                s = DBConn.createStatement();

                SQLstatement = ( "CREATE TABLE " + orderTableName +
                            "(item_id int unsigned not null auto_increment primary key, " +
                            "product_id varchar(20), description varchar(80), " +
                            "item_price float(7,2) );");

                executeUpdateVal = s.executeUpdate(SQLstatement);

            } catch (Exception e) {

                errString =  "\nProblem creating order table " + orderTableName +":: " + e;
                jTextArea3.append(errString);
                executeError = true;

            } // try

            if ( !executeError )
            {
                try
                {
                    SQLstatement = ( "INSERT INTO orders (order_date, " + "first_name, " +
                        "last_name, address, phone, total_cost, shipped, " +
                        "ordertable) VALUES ( '" + dateTimeStamp + "', " +
                        "'" + firstName + "', " + "'" + lastName + "', " +
                        "'" + customerAddress + "', " + "'" + phoneNumber + "', " +
                        fCost + ", " + false + ", '" + orderTableName +"' );");

                    executeUpdateVal = s.executeUpdate(SQLstatement);
                    
                } catch (Exception e1) {

                    errString =  "\nProblem with inserting into table orders:: " + e1;
                    jTextArea3.append(errString);
                    executeError = true;

                    try
                    {
                        SQLstatement = ( "DROP TABLE " + orderTableName + ";" );
                        executeUpdateVal = s.executeUpdate(SQLstatement);

                    } catch (Exception e2) {

                        errString =  "\nProblem deleting unused order table:: " +
                                orderTableName + ":: " + e2;
                        jTextArea3.append(errString);

                    } // try

                } // try

            } //execute error check

    }

    public Order GetOrder(int OrderId) {
        Connection DBConn = null;
        try {
            DBConn = DriverManager.getConnection(sourceURL,"remote","remote_pass");
            
            /*SQL command to select a single order from the SQL database*/
            Statement s = DBConn.createStatement();
            String SQLStatement = ("SELECT * FROM orders WHERE order_id = " + Integer.toString(OrderId) + "");
            ResultSet res = s.executeQuery(SQLStatement);
            
            
        }//try
        catch (/**/){
            
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
