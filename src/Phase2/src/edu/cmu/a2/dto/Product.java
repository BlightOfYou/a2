/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.dto;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.Id);
        hash = 37 * hash + Objects.hashCode(this.Type);
        hash = 37 * hash + Objects.hashCode(this.Description);
        hash = 37 * hash + Float.floatToIntBits(this.Price);
        hash = 37 * hash + this.Quantity;
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.Type, other.Type)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (Float.floatToIntBits(this.Price) != Float.floatToIntBits(other.Price)) {
            return false;
        }
        if (this.Quantity != other.Quantity) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s : %s : %s : $%.2f : %d units in stock", Id, Type, Description, Price, Quantity);
    }
    
    
}
