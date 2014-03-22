package edu.cmu.a2.ui;

import edu.cmu.a2.middle.*;
import edu.cmu.a2.dto.*;
import edu.cmu.a2.common.*;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/******************************************************************************
 * File:NewJFrame.java
 * Course: 17655
 * Project: Assignment 2
 * Copyright: Copyright (c) 2009 Carnegie Mellon University
 * Versions:
 *	1.0 November 2009 - Initial rewrite of original assignment 2 (ajl).
 *
 * This class defines a GUI application that allows EEP order takers to enter
 * phone orders into the database.
 *
 ******************************************************************************/

/**
 *
 * @author lattanze
 */
public class OrderMainFrame extends MainFrame {
    
    String spacer = " : ";
    InventoryService inventoryService = null;
    OrderService orderService = null;
    List<OrderItem> orderItems = new ArrayList<>();
    
//    OrderService orderService = new OrderService(databaseStr);
    /** Creates new form NewJFrame */
    public OrderMainFrame(Session session) {
        super(session);
        
        initComponents();
        jLabel1.setText("Order Management Application " + versionID);
        databaseServerIpText.setText(session.getServerHost());
        
        try {
            inventoryService = connectToInventoryService();
        } catch (Exception e) {
            connectError = true;
        }
        
        try {
            orderService = connectToOrderService();
        } catch (Exception e) {
            connectError = true;
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTextArea = new javax.swing.JTextArea();
        treesButton = new javax.swing.JButton();
        seedsButton = new javax.swing.JButton();
        shrubsButton = new javax.swing.JButton();
        cultureBoxesButton = new javax.swing.JButton();
        genomicsButton = new javax.swing.JButton();
        processesButton = new javax.swing.JButton();
        referenceMaterialsButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsSelectedTextArea = new javax.swing.JTextArea();
        firstNameText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        phoneTextArea = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        itemsSelectedLabel = new javax.swing.JLabel();
        addToOrderButton = new javax.swing.JButton();
        costLabel = new javax.swing.JLabel();
        costText = new javax.swing.JTextField();
        submitOrderButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        messagesLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        messagesTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        databaseServerIpLabel = new javax.swing.JLabel();
        databaseServerIpText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Order Management Application");

        inventoryTextArea.setEditable(false);
        inventoryTextArea.setColumns(20);
        inventoryTextArea.setRows(5);
        jScrollPane1.setViewportView(inventoryTextArea);

        treesButton.setText("Trees");
        treesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treesButtonActionPerformed(evt);
            }
        });

        seedsButton.setText("Seeds");
        seedsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedsButtonActionPerformed(evt);
            }
        });

        shrubsButton.setText("Shrubs");
        shrubsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shrubsButtonActionPerformed(evt);
            }
        });

        cultureBoxesButton.setText("Culture Boxes");
        cultureBoxesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultureBoxesButtonActionPerformed(evt);
            }
        });

        genomicsButton.setText("Genomics");
        genomicsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genomicsButtonActionPerformed(evt);
            }
        });

        processesButton.setText("Processes");
        processesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processesButtonActionPerformed(evt);
            }
        });

        referenceMaterialsButton.setText("Reference Materials");
        referenceMaterialsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceMaterialsButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Press Button For Inventory Display");

        itemsSelectedTextArea.setColumns(20);
        itemsSelectedTextArea.setRows(5);
        jScrollPane2.setViewportView(itemsSelectedTextArea);

        jLabel6.setText("First Name");

        jLabel7.setText("Last Name");

        lastNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextActionPerformed(evt);
            }
        });

        phoneTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextAreaActionPerformed(evt);
            }
        });

        jLabel8.setText("Phone #");

        itemsSelectedLabel.setText("Items Selected:");

        addToOrderButton.setText("Add to Order");
        addToOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToOrderButtonActionPerformed(evt);
            }
        });

        costLabel.setText("Order Total Cost:");

        costText.setText("$0");
        costText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costTextActionPerformed(evt);
            }
        });

        submitOrderButton.setText("Submit Order");
        submitOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitOrderButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Product ID : Product Description : Price : Items in Stock");

        messagesLabel.setText("Messages:");

        messagesTextArea.setColumns(20);
        messagesTextArea.setRows(5);
        jScrollPane3.setViewportView(messagesTextArea);

        jLabel3.setText("Customer Information");

        databaseServerIpLabel.setText("Server IP Address:");

        databaseServerIpText.setEditable(false);
        databaseServerIpText.setText("localhost");

        jLabel12.setText("Address");

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane4.setViewportView(addressTextArea);

        jLabel13.setText("SELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER (TRIPLE CLICK)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lastNameText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTextArea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(itemsSelectedLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(databaseServerIpLabel))
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(messagesLabel))
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel10)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(treesButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(seedsButton)
                                                .addGap(27, 27, 27)
                                                .addComponent(shrubsButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(cultureBoxesButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(genomicsButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(processesButton)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(referenceMaterialsButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addToOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(costLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(costText))
                                .addComponent(databaseServerIpText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(submitOrderButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(databaseServerIpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(databaseServerIpLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(treesButton)
                        .addComponent(seedsButton)
                        .addComponent(shrubsButton)
                        .addComponent(cultureBoxesButton)
                        .addComponent(genomicsButton)
                        .addComponent(processesButton)
                        .addComponent(referenceMaterialsButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addToOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(costLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(costText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemsSelectedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitOrderButton)
                        .addGap(1, 1, 1)
                        .addComponent(messagesLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void treesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treesButtonActionPerformed
        productType = "trees";
        displayTypeList();
    }//GEN-LAST:event_treesButtonActionPerformed
    
    private void addToOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToOrderButtonActionPerformed
        // This button gets the selected line of text from the
        // inventory list window jTextArea1. The line of text is parsed and
        // the relevant information is placed in the order area (jTextArea2).
        
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        Float fCost;                        // Item cost
        String productDescription = null;   // Product description
        String productID = null;            // Product ID pnemonic
        String sCost,sTotalCost;            // String order and total cost values
        String quantity = null;
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        String thisProductType = null;
        // Initialization
        
        String inventorySelection = null;
        IndexNotFound = false;
        sCost = null;
        sTotalCost = null;
        
        
        
        // this is the selected line of text
        inventorySelection =  inventoryTextArea.getSelectedText();
        
        // make sure its not blank
        if ( inventorySelection != null )
        {
            // get the product ID
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(spacer,beginIndex);
            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                productID = inventorySelection.substring(beginIndex,endIndex);
            }
            
            // get the product type
            beginIndex = endIndex + spacer.length();
            endIndex = inventorySelection.indexOf(spacer,beginIndex);
            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                thisProductType = inventorySelection.substring(beginIndex,endIndex);
            }
            
            // get the product description
            if ( !IndexNotFound )
            {
                beginIndex = endIndex + spacer.length(); //skip over " : "
                endIndex = inventorySelection.indexOf(spacer,beginIndex);
                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productDescription = inventorySelection.substring(beginIndex,endIndex);
                }
            }
            
            // get the string cost value
            if ( !IndexNotFound )
            {
                beginIndex = endIndex + spacer.length() + 1; //skip over " : $"
                endIndex = inventorySelection.indexOf(spacer,beginIndex);
                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    sCost = inventorySelection.substring(beginIndex,endIndex);
                }
            }
            
            // write the string to the order area
            
            if ( !IndexNotFound )
            {
//                TO DO: fill in order item constructor
//                OrderItem orderItem = new OrderItem(int ItemId, int ProductId, int Description, float ItemPrice)
                itemsSelectedTextArea.append( productID + spacer + productDescription + spacer + "$"
                        + sCost + "\n");
                
                // convert the string cost to a float, add it to what is in the
                // cost field (jTextField6), and update the cost field with the
                // new value
                
                sTotalCost = costText.getText();
                beginIndex = 0;
                beginIndex = sTotalCost.indexOf("$",beginIndex)+1;
                sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
                fCost = Float.parseFloat(sTotalCost) + Float.parseFloat(sCost);
                costText.setText( "$" + fCost.toString());
                
//                OrderItem orderItem = new OrderItem(0, Integer.parseInt(productID), productDescription, fCost);
                orderItems.add(new OrderItem(0, productID, productDescription, fCost));
                
            } else {
                messagesTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            }
        } else {
            messagesTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        } // Blank string check
    }//GEN-LAST:event_addToOrderButtonActionPerformed
    
    private void costTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costTextActionPerformed
    
    private void submitOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitOrderButtonActionPerformed
        // This is the submit order button. This handler will check to make sure
        // that the customer information is provided, then create an entry in
        // the orderinfo::orders table. It will also create another table where
        // the list of items is stored. This table is also in the orderinfo
        // database as well.
        
        int beginIndex;                 // String parsing index
        
        String customerAddress = null;         // Buyers mailing address
        int endIndex;                   // String paring index
        String firstName = null;        // Customer's first name
        Connection DBConn = null;       // MySQL connection handle
        float fCost = 0;                    // Total order cost
        String description;             // Tree, seed, or shrub description
        Boolean executeError = false;   // Error flag
        String errString = null;        // String for displaying errors
        int executeUpdateVal;           // Return value from execute indicating effected rows
        String lastName = null;         // Customer's last name
        String msgString = null;        // String for displaying non-error messages
        String orderTableName = null;   // This is the name of the table that lists the items
        String sTotalCost = null;       // String representing total order cost
        String sPerUnitCost = null;     // String representation of per unit cost
        String orderItem = null;        // Order line item from jTextArea2
        String phoneNumber = null;      // Customer phone number
        Float perUnitCost;              // Cost per tree, seed, or shrub unit
        String productID = null;        // Product id of tree, seed, or shrub
        Statement s = null;             // SQL statement pointer
        String SQLstatement = null;     // String for building SQL queries
        Boolean shipped = false;
        String dateTimeStamp = null;
        // Check to make sure there is a first name, last name, address and phone
        if ((firstNameText.getText().length()>0) && (lastNameText.getText().length()>0)
                && (phoneTextArea.getText().length()>0)
                && (addressTextArea.getText().length()>0))
        {
            
// This used to be the code to connect to the database
            
        } else {
            
            errString =  "\nMissing customer information!!!\n";
            messagesTextArea.append(errString);
            connectError = true;
            
        }// customer data check
        
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
            
            dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                    + TheHour + ":" + TheMinute  + ":" + TheSecond;
            
            // Get the order data
            firstName = firstNameText.getText();
            lastName = lastNameText.getText();
            phoneNumber = phoneTextArea.getText();
            customerAddress = addressTextArea.getText();
            sTotalCost = costText.getText();
            beginIndex = 0;
            beginIndex = sTotalCost.indexOf("$",beginIndex)+1;
            sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
            fCost = Float.parseFloat(sTotalCost);
            
        }
        
//        // Now, if there is no connect or SQL execution errors at this point,
//        // then we have an order added to the orderinfo::orders table, and a
//        // new ordersXXXX table created. Here we insert the list of items in
//        // jTextArea2 into the ordersXXXX table.
//
        if ( !connectError && !executeError )
        {
            // Now we create a table that contains the itemized list
            // of stuff that is associated with the order
            
            String[] items = itemsSelectedTextArea.getText().split("\\n");
            
            for (int i = 0; i < items.length; i++ )
            {
                orderItem = items[i];
                messagesTextArea.append("\nitem #:" + i + ": " + items[i]);
                
                // Check just to make sure that a blank line was not stuck in
                // there... just in case.
                
                if (orderItem.length() > 0 )
                {
                    // Parse out the product id
                    beginIndex = 0;
                    endIndex = orderItem.indexOf(spacer,beginIndex);
                    productID = orderItem.substring(beginIndex,endIndex);
                    
                    // Parse out the description text
                    beginIndex = endIndex + spacer.length(); //skip over " : "
                    endIndex = orderItem.indexOf(spacer,beginIndex);
                    description = orderItem.substring(beginIndex,endIndex);
                    
                    // Parse out the item cost
                    beginIndex = endIndex + spacer.length() + 1; //skip over " : $"
                    //endIndex = orderItem.indexOf(" : ",orderItem.length());
                    //sPerUnitCost = orderItem.substring(beginIndex,endIndex);
                    sPerUnitCost = orderItem.substring(beginIndex,orderItem.length());
                    perUnitCost = Float.parseFloat(sPerUnitCost);
                    
                    
                    Order order = new Order(0, dateTimeStamp, firstName, lastName, customerAddress, phoneNumber, fCost, shipped, orderItems );
//
                    try
                    {
//                Need to create order object to pass in to SubmitOrder
                        this.orderService.SubmitOrder(order);
                        msgString =  "\nORDER SUBMITTED FOR: " + firstName + " " + lastName;
                        messagesTextArea.setText(msgString);
                        clearTextArea();
                        
                    } catch (Exception e) {
                        
                        errString =  "\nProblem submitting order:: " + e;
                        messagesTextArea.append(errString);
                        executeError = true;
                        
                    } // try
                    
                    
                } // line length check
                
            } //for each line of text in order table
            
        }
        
    }//GEN-LAST:event_submitOrderButtonActionPerformed
    
    private void lastNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextActionPerformed
    
    private void seedsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedsButtonActionPerformed
        productType = "seeds";
        displayTypeList();
    }//GEN-LAST:event_seedsButtonActionPerformed
    
    private void shrubsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shrubsButtonActionPerformed
        
        productType = "shrubs";
        displayTypeList();
    }//GEN-LAST:event_shrubsButtonActionPerformed
    
    private void displayTypeList() {
        
        // jButton1 is responsible for querying the inventory database and
        // getting the tree inventory. Once retieved, the tree inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.
        
        // String for displaying errors
        
        List<Product> products = new ArrayList<Product>();
        
        // If we are connected, then we get the list of trees from the
        // inventory database
        
        if ( !connectError )
        {
            try
            {
                //Display the data in the textarea
                
                inventoryTextArea.setText("");
                products = this.inventoryService.GetProducts(productType);
                
                inventoryTextArea.setText("");
                
                for (Product thisProduct : products) {
                    inventoryTextArea.append("\n"+thisProduct.toString());
                    
                }
                
                
            } catch (Exception e) {
                
                errString =  "\nProblem getting inventory:: " + e;
                inventoryTextArea.append(errString);
                
            } // end try-catch
        } // if connect check
        
    }
    
    private void phoneTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextAreaActionPerformed
    
    private void cultureBoxesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cultureBoxesButtonActionPerformed
        productType = "cultureboxes";
        displayTypeList();
    }//GEN-LAST:event_cultureBoxesButtonActionPerformed
    
    private void genomicsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genomicsButtonActionPerformed
        productType = "genomics";
        displayTypeList();
    }//GEN-LAST:event_genomicsButtonActionPerformed
    
    private void processesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processesButtonActionPerformed
        productType = "processes";
        displayTypeList();
    }//GEN-LAST:event_processesButtonActionPerformed
    
    private void referenceMaterialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceMaterialsButtonActionPerformed
        productType = "referencematerials";
        displayTypeList();
    }//GEN-LAST:event_referenceMaterialsButtonActionPerformed
    
    private void clearTextArea() {
        inventoryTextArea.setText("");
        itemsSelectedTextArea.setText("");
        addressTextArea.setText("");
        firstNameText.setText("");
        lastNameText.setText("");
        phoneTextArea.setText("");
        costText.setText("$0");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                LoginDialog login = new LoginDialog();
                login.setModal(true);
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                
                Session session = login.getSession();
                
                if(session != null) {
                    new OrderMainFrame(session).setVisible(true);
                }
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToOrderButton;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextField costText;
    private javax.swing.JButton cultureBoxesButton;
    private javax.swing.JLabel databaseServerIpLabel;
    private javax.swing.JTextField databaseServerIpText;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JButton genomicsButton;
    private javax.swing.JTextArea inventoryTextArea;
    private javax.swing.JLabel itemsSelectedLabel;
    private javax.swing.JTextArea itemsSelectedTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JLabel messagesLabel;
    private javax.swing.JTextArea messagesTextArea;
    private javax.swing.JTextField phoneTextArea;
    private javax.swing.JButton processesButton;
    private javax.swing.JButton referenceMaterialsButton;
    private javax.swing.JButton seedsButton;
    private javax.swing.JButton shrubsButton;
    private javax.swing.JButton submitOrderButton;
    private javax.swing.JButton treesButton;
    // End of variables declaration//GEN-END:variables
    
}
