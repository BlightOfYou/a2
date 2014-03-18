/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.dto;

/**
 *
 */
public class OrderItem {

    public int ItemId;
    public int ProductId;
    public int Description;
    public float ItemPrice;

    public OrderItem(int ItemId, int ProductId, int Description, float ItemPrice) {
        this.ItemId = ItemId;
        this.ProductId = ProductId;
        this.Description = Description;
        this.ItemPrice = ItemPrice;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getDescription() {
        return Description;
    }

    public void setDescription(int Description) {
        this.Description = Description;
    }

    public float getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(float ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

}
