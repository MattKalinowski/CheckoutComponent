package com.matthew.checkout.checkoutcomponent.domain;

import java.util.List;

import static com.matthew.checkout.checkoutcomponent.domain.ItemUtils.*;

public class PriceCalculator implements IPriceCalculator {
    
    private List<Item> items;
    private double totalPrice;
    private double discount;

    public PriceCalculator(List<Item> items) {
        this.items = items;
    }

    @Override
    public double quantityOfItem(String name) {
        return items.stream().filter(item -> item.getItemName().equals(name)).count();
    }

    @Override
    public void determineDiscount() {

        if (quantityOfItem("A") > 14) {
            discount += (quantityOfItem("A") * returnItemDiscount("A"));
        }
        if (quantityOfItem("B") > 9) {
            discount += (quantityOfItem("B") * returnItemDiscount("B"));
        }
        if (quantityOfItem("C") > 7) {
            discount += (quantityOfItem("C") * returnItemDiscount("C"));
        }
        if (quantityOfItem("D") > 4) {
            discount += (quantityOfItem("D") * returnItemDiscount("D"));
        }
    }

    @Override
    public void calculateTotalPrice() {
        for (Item i : items) {
            totalPrice += i.getPrice();
        }
        totalPrice -= discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

}
