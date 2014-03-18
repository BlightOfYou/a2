/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.dto;

/**
 *
 */
public class Product {

    public String Id; //varchar(10)
    public String Type;
    public String Description; //varchar(80)
    public float Price; //float(10,2)
    public int Quantity; //int(11)

    public Product(String Id, String Type, String Description, float Price, int Quantity) {
        this.Id = Id;
        this.Type = Type;
        this.Description = Description;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
