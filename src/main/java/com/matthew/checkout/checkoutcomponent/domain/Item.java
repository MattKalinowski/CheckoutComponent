package com.matthew.checkout.checkoutcomponent.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static com.matthew.checkout.checkoutcomponent.domain.ItemUtils.*;

@Entity
public class Item {

    @Id  @GeneratedValue(strategy= GenerationType.AUTO)
    private long itemId;
    private String itemName;
    private double price;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemId) {
        this.itemName = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        price = returnItemPrice(itemName);
    }

}
