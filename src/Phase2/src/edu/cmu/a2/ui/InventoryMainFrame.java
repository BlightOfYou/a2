package edu.cmu.a2.ui;

import edu.cmu.a2.ui.*;
import edu.cmu.a2.middle.*;
import edu.cmu.a2.dto.*;
import edu.cmu.a2.common.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class InventoryMainFrame extends MainFrame { //extends javax.swing.JFrame {
    
    
    private Boolean isEepProduct = false;
    private Boolean isLeafTechProduct = false;
    InventoryService inventoryService = null;
    
    /** Creates new form AddInventoryMainFrame */
    public InventoryMainFrame(Session session) {
        super(session);
                
        initComponents();
        frameTitleLabel.setText("Inventory Management Application " + versionID);
        databaseServerIpText.setText(session.getServerHost());

        
        try {
            inventoryService = connectToInventoryService();
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

        treesRadioButton = new javax.swing.JRadioButton();
        seedsRadioButton = new javax.swing.JRadioButton();
        shrubsRadioButton = new javax.swing.JRadioButton();
        frameTitleLabel = new javax.swing.JLabel();
        productIdLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        databaseServerIpText = new javax.swing.JTextField();
        productIdText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        addItemButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        inventoryScrollPane = new javax.swing.JScrollPane();
        inventoryTextArea = new javax.swing.JTextArea();
        productDescriptionLabel = new javax.swing.JLabel();
        databaseServerIpLabel = new javax.swing.JLabel();
        productDescriptionText = new javax.swing.JTextField();
        listInventoryButton = new javax.swing.JButton();
        deleteItemButton = new javax.swing.JButton();
        decrementButton = new javax.swing.JButton();
        deleteText = new javax.swing.JLabel();
        decrementText = new javax.swing.JLabel();
        cultureBoxesRadioButton = new javax.swing.JRadioButton();
        genomicsRadioButton = new javax.swing.JRadioButton();
        processingRadioButton = new javax.swing.JRadioButton();
        referenceMaterialsRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        treesRadioButton.setText("Trees");
        treesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treesRadioButtonActionPerformed(evt);
            }
        });

        seedsRadioButton.setText("Shrubs");
        seedsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedsRadioButtonActionPerformed(evt);
            }
        });

        shrubsRadioButton.setText("Seeds");
        shrubsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shrubsRadioButtonActionPerformed(evt);
            }
        });

        frameTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        frameTitleLabel.setText("EEPs Inventory Management Application");

        productIdLabel.setText("Product ID");

        priceLabel.setText("Price");

        quantityLabel.setText("Quantity");

        databaseServerIpText.setEditable(false);
        databaseServerIpText.setText("localhost");

        productIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdTextActionPerformed(evt);
            }
        });

        addItemButton.setText("Add Item");
        addItemButton.setActionCommand("jButton1");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        inventoryTextArea.setColumns(20);
        inventoryTextArea.setRows(5);
        inventoryScrollPane.setViewportView(inventoryTextArea);

        productDescriptionLabel.setText("Product Description");

        databaseServerIpLabel.setText("Database Server IP");

        productDescriptionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDescriptionTextActionPerformed(evt);
            }
        });

        listInventoryButton.setText("List Inventory");
        listInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listInventoryButtonActionPerformed(evt);
            }
        });

        deleteItemButton.setText("Delete Item");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        decrementButton.setText("Decrement");
        decrementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrementButtonActionPerformed(evt);
            }
        });

        deleteText.setText("Deletes item selected from list ");

        decrementText.setText("Decrements inventory count of item selected from the list");

        cultureBoxesRadioButton.setText("Culture Boxes");
        cultureBoxesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultureBoxesRadioButtonActionPerformed(evt);
            }
        });

        genomicsRadioButton.setText("Genomics");
        genomicsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genomicsRadioButtonActionPerformed(evt);
            }
        });

        processingRadioButton.setText("Processing");
        processingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processingRadioButtonActionPerformed(evt);
            }
        });

        referenceMaterialsRadioButton.setText("Reference Materials");
        referenceMaterialsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceMaterialsRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productIdLabel)
                            .addComponent(productDescriptionLabel)
                            .addComponent(priceLabel)
                            .addComponent(quantityLabel))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(priceText)
                                    .addComponent(quantityText)
                                    .addComponent(productIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(treesRadioButton)
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(shrubsRadioButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(seedsRadioButton))))
                                    .addComponent(listInventoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(decrementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(decrementText, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(deleteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(deleteText))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cultureBoxesRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(genomicsRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(processingRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(referenceMaterialsRadioButton)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inventoryScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(databaseServerIpLabel)
                        .addGap(17, 17, 17)
                        .addComponent(databaseServerIpText, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(frameTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(databaseServerIpLabel)
                            .addComponent(databaseServerIpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(productDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(productDescriptionLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(treesRadioButton)
                    .addComponent(productIdLabel)
                    .addComponent(shrubsRadioButton)
                    .addComponent(seedsRadioButton)
                    .addComponent(cultureBoxesRadioButton)
                    .addComponent(genomicsRadioButton)
                    .addComponent(processingRadioButton)
                    .addComponent(referenceMaterialsRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel)
                    .addComponent(deleteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteText)
                    .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decrementButton)
                    .addComponent(decrementText)
                    .addComponent(listInventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void treesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treesRadioButtonActionPerformed
        
        eepRadioButtonSelected();
        treesRadioButton.setSelected(true);
        productType = "trees";
        
    }//GEN-LAST:event_treesRadioButtonActionPerformed
    
    private void shrubsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shrubsRadioButtonActionPerformed
        
        eepRadioButtonSelected();
        shrubsRadioButton.setSelected(true);
        productType = "shrubs";
    }//GEN-LAST:event_shrubsRadioButtonActionPerformed
    
    private void seedsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedsRadioButtonActionPerformed
        
        eepRadioButtonSelected();
        seedsRadioButton.setSelected(true);
        productType = "seeds";
    }//GEN-LAST:event_seedsRadioButtonActionPerformed
    
    
    
    private void eepRadioButtonSelected() {
        
        productTypeRadioButtonSelected();
        isEepProduct = true;
        isLeafTechProduct = false;
    }
    
    private void leafTechRadioButtonSelected() {
        
        productTypeRadioButtonSelected();
        isEepProduct = false;
        isLeafTechProduct = true;
    }
    
    private void productTypeRadioButtonSelected() {
        treesRadioButton.setSelected(false);
        shrubsRadioButton.setSelected(false);
        seedsRadioButton.setSelected(false);
        cultureBoxesRadioButton.setSelected(false);
        genomicsRadioButton.setSelected(false);
        referenceMaterialsRadioButton.setSelected(false);
        processingRadioButton.setSelected(false);
    }
    
    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        
        // Adds inventory to database
        
        
        String description;             // Tree, seed, or shrub description
        Boolean executeError = false;   // Error flag
        String errString = null;        // String for displaying errors
        int executeUpdateVal;           // Return value from execute indicating effected rows
        Boolean fieldError = false;     // Error flag
        String msgString = null;        // String for displaying non-error messages
        ResultSet res = null;           // SQL query result set pointer
        String tableSelected = null;    // String used to determine which data table to use
        Integer quantity;               // Quantity of trees, seeds, or shrubs
        Float perUnitCost;              // Cost per tree, seed, or shrub unit
        String productID = null;        // Product id of tree, seed, or shrub
        
        
        // Check to make sure a radio button is selected
        
        inventoryTextArea.setText("");
        
        if (!treesRadioButton.isSelected() && !shrubsRadioButton.isSelected() && !seedsRadioButton.isSelected() && !cultureBoxesRadioButton.isSelected() && !genomicsRadioButton.isSelected() && !processingRadioButton.isSelected() && !referenceMaterialsRadioButton.isSelected())
        {
            fieldError = true;
            inventoryTextArea.append("\nMust select product type.");
            
        } else {
            
            //Make sure there is a product description
            if ( productDescriptionText.getText().length() == 0 )
            {
                fieldError = true;
                inventoryTextArea.append("\nMust enter a product description.");
                
            } else {
                
                //Make sure there is a product ID
                if ( productIdText.getText().length() == 0 )
                {
                    fieldError = true;
                    inventoryTextArea.append("\nMust enter a product ID.");
                } else {
                    
                    //Make sure there is a price
                    if ( priceText.getText().length() == 0 )
                    {
                        fieldError = true;
                        inventoryTextArea.append("\nMust enter a product price.");
                    } else {
                        
                        //Make sure quantity is specified
                        if ( quantityText.getText().length() == 0 )
                        {
                            fieldError = true;
                            inventoryTextArea.append("\nMust enter a product quantity.");
                        } // quantity
                    } // price
                } // product ID
            } //product description
        } //category selected
        
        
        //If there is not connection error, then we form the SQL statement
        //and then execute it.
        
        if (!connectError && !fieldError )
        {
            try
            {
                // get the data from the text fields
                description = productDescriptionText.getText();
                productID = productIdText.getText();
                quantity = Integer.parseInt(quantityText.getText());
                perUnitCost = Float.parseFloat(priceText.getText());
                
                // create an SQL statement variable and create the INSERT
                // query to insert the new inventory into the database
                
                Product product = new Product(productID, productType, description, perUnitCost, quantity);
                this.inventoryService.AddProduct(product);
                // let the user know all went well
                
                inventoryTextArea.append("\nINVENTORY UPDATED... The following was added to the " + tableSelected + " inventory...\n");
                inventoryTextArea.append("\nProduct Code:: " + productID);
                inventoryTextArea.append("\nDescription::  " + description);
                inventoryTextArea.append("\nQuantity::     " + quantity);
                inventoryTextArea.append("\nUnit Cost::    " + perUnitCost);
                
            } catch (Exception e) {
                
                errString =  "\nProblem adding inventory:: " + e;
                inventoryTextArea.append(errString);
                executeError = true;
                
            } // try
            
        } //execute SQL check
        
    }//GEN-LAST:event_addItemButtonActionPerformed
    
    private void listInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listInventoryButtonActionPerformed
        // This button will list the inventory for the product selected by the
        // radio button
        
//        Boolean connectError = false;   // Error flag
//        Connection DBConn = null;       // MySQL connection handle
        Boolean executeError = false;   // Error flag
        String errString = null;        // String for displaying errors
        Boolean fieldError = true;      // Error flag
        String msgString = null;        // String for displaying non-error messages
//        ResultSet res = null;           // SQL query result set pointer
        String tableSelected = null;    // String used to determine which data table to use
        java.sql.Statement s = null;    // SQL statement pointer
        
        List<Product> products = new ArrayList<>();
        
//        InventoryService inventoryService = null;
//
//        try {
//            inventoryService = connectToInventoryService(databaseServerIpText.getText());
//        } catch (Exception e) {
//            connectError = true;
//        }

        
        
        // Check to make sure a radio button is selected
        if (isEepProduct || isLeafTechProduct)
        {
            fieldError = false;
            
        } else {
            
            msgString = "Must select radio button.";
            inventoryTextArea.setText("\n"+msgString);
        }
        
        //If there is not connection error, then we form the SQL statement
        //and then execute it.
        
        if (!connectError && !fieldError)
        {
            try
            {
                
                products = this.inventoryService.GetProducts(productType);
                
                // Now we list the inventory for the selected table
                inventoryTextArea.setText("");

                for (Product thisProduct : products) {
                    inventoryTextArea.append("\n"+thisProduct.toString());
                    
                }
 
            } catch(SQLException e) {
                
                errString =  "\nProblem with " + tableSelected +" query:: " + e;
                inventoryTextArea.append(errString);
                executeError = true;
                
            } // try
        }
    }//GEN-LAST:event_listInventoryButtonActionPerformed
    
    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        // Deletes an item from the database
        
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        java.sql.Statement s = null;        // SQL statement pointer
        String inventorySelection = null;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found
        
        // this is the selected line of text
        inventorySelection =  inventoryTextArea.getSelectedText();
        
        // make sure the selection is not blank
        if ( inventorySelection != null )
        {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>",beginIndex);
            
            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex+2; //skip past ">>"
            }
            
            if ( !IndexNotFound )
            {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":",beginIndex);
                
                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex,endIndex);
                }
            }
            
            // Now we delete the inventory item indicated by the productID we
            // parsed out above from the indicated table.
            
            if ( !IndexNotFound )
            {
                inventoryTextArea.setText("");
                inventoryTextArea.append( "Deleting ProductID: " + productID );
                
                
                //If there is no connection error, then we form the SQL statement
                //to delete the inventory item and then execute it.
                
                if (!connectError )
                {
                    try
                    {
                        
                        this.inventoryService.DeleteProduct(productType, productID);
                        
                        // let the user know all went well
                        
                        inventoryTextArea.append("\n\n" + productID + " deleted...");
                        
                        
                    } catch (SQLException e) {
                        
                        errString =  "\nProblem with delete:: " + e;
                        inventoryTextArea.append(errString);
                        
                    } // try
                    
                } // connection check
                
            } else {
                
                inventoryTextArea.setText("");
                inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
                
            }
        } else {
            
            inventoryTextArea.setText("");
            inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            
        } // Blank string check
        
    }//GEN-LAST:event_deleteItemButtonActionPerformed
    
    private void decrementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrementButtonActionPerformed
        // Decrements the inventory count for a selected item
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        
        String errString = null;            // String for displaying errors
        ResultSet res = null;               // SQL query result set pointer
        String inventorySelection = null;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found
        
        
        // this is the selected line of text
        inventorySelection =  inventoryTextArea.getSelectedText();
        
        // make sure the selection is not blank
        if ( inventorySelection != null )
        {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>",beginIndex);
            
            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex+2; //skip past ">>"
            }
            
            if ( !IndexNotFound )
            {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":",beginIndex);
                
                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex,endIndex);
                }
            }
            
            // Now we decrement the inventory count of the item indicated by the productID we
            // parsed out above from the indicated table.
            
            if ( !IndexNotFound )
            {
                inventoryTextArea.setText("");
                inventoryTextArea.append( "Deleting ProductID: " + productID );
                
                
                //If there is no connection error, then we form the SQL statement
                //to decrement the inventory item count and then execute it.
                
                if (!connectError )
                {
                    try
                    {
                        
//                        int productIdInt = Integer.parseInt(productId);
                        this.inventoryService.DecrementProduct(productType, productID);
                        
                        // Inform user that type was updated
                        inventoryTextArea.append("\n\n Number of items updated. "  );
                        
                    } catch (Exception e) {
                        
                        errString =  "\nProblem with delete:: " + e;
                        inventoryTextArea.append(errString);
                        
                    } // try
                    
                } // connection check
                
            } else {
                
                inventoryTextArea.setText("");
                inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
                
            }
        } else {
            
            inventoryTextArea.setText("");
            inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            
        } // Blank string check
    }//GEN-LAST:event_decrementButtonActionPerformed
    
    
    
    
    
    
    private void productDescriptionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDescriptionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productDescriptionTextActionPerformed
    
    private void productIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdTextActionPerformed
    
    
    private void cultureBoxesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cultureBoxesRadioButtonActionPerformed
        
        leafTechRadioButtonSelected();
        cultureBoxesRadioButton.setSelected(true);
        productType = "cultureboxes";
    }//GEN-LAST:event_cultureBoxesRadioButtonActionPerformed
    
    private void genomicsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genomicsRadioButtonActionPerformed
        
        leafTechRadioButtonSelected();
        genomicsRadioButton.setSelected(true);
        productType = "genomics";
    }//GEN-LAST:event_genomicsRadioButtonActionPerformed
    
    private void processingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processingRadioButtonActionPerformed
        
        leafTechRadioButtonSelected();
        processingRadioButton.setSelected(true);
        productType = "processing";
    }//GEN-LAST:event_processingRadioButtonActionPerformed
    
    private void referenceMaterialsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceMaterialsRadioButtonActionPerformed
        
        leafTechRadioButtonSelected();
        referenceMaterialsRadioButton.setSelected(true);
        productType = "referencematerials";
    }//GEN-LAST:event_referenceMaterialsRadioButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                LoginFrame login = new LoginFrame();
                login.setModal(true);
                login.setVisible(true);
                
                Session session = login.getSession();
                
                if(session != null) {
                    new InventoryMainFrame(session).setVisible(true);    
                }
                
                
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JRadioButton cultureBoxesRadioButton;
    private javax.swing.JLabel databaseServerIpLabel;
    private javax.swing.JTextField databaseServerIpText;
    private javax.swing.JButton decrementButton;
    private javax.swing.JLabel decrementText;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JLabel deleteText;
    private javax.swing.JLabel frameTitleLabel;
    private javax.swing.JRadioButton genomicsRadioButton;
    private javax.swing.JScrollPane inventoryScrollPane;
    private javax.swing.JTextArea inventoryTextArea;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton listInventoryButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceText;
    private javax.swing.JRadioButton processingRadioButton;
    private javax.swing.JLabel productDescriptionLabel;
    private javax.swing.JTextField productDescriptionText;
    private javax.swing.JLabel productIdLabel;
    private javax.swing.JTextField productIdText;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityText;
    private javax.swing.JRadioButton referenceMaterialsRadioButton;
    private javax.swing.JRadioButton seedsRadioButton;
    private javax.swing.JRadioButton shrubsRadioButton;
    private javax.swing.JRadioButton treesRadioButton;
    // End of variables declaration//GEN-END:variables
    
}
