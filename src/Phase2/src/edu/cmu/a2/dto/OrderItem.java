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
    public String ProductId;
    public String Description;
    public float ItemPrice;

    public OrderItem(int ItemId, String ProductId, String Description, float ItemPrice) {
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

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(float ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.ItemId;
        hash = 37 * hash + this.ProductId.hashCode();
        hash = 37 * hash + this.Description.hashCode();
        hash = 37 * hash + Float.floatToIntBits(this.ItemPrice);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (this.ItemId != other.ItemId) {
            return false;
        }
        if (this.ProductId != other.ProductId) {
            return false;
        }
        if (this.Description != other.Description) {
            return false;
        }
        if (Float.floatToIntBits(this.ItemPrice) != Float.floatToIntBits(other.ItemPrice)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ">>" + ItemId + "::" + 
                ProductId + "::" + 
                Description + "::" + 
                ItemPrice;
                //"OrderItem{" + "ItemId=" + ItemId + ", ProductId=" + ProductId + ", Description=" + Description + ", ItemPrice=" + ItemPrice + '}';
    }

}
