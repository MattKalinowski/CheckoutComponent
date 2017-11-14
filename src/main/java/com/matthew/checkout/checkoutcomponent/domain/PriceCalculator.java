package com.matthew.checkout.checkoutcomponent.domain;

import java.util.List;

import static com.matthew.checkout.checkoutcomponent.domain.ItemUtils.*;

public class PriceCalculator implements IPriceCalculator {
    
    private List<Item> items;
    private double discount;
    private double totalPrice;

    public PriceCalculator(List<Item> items) {
        this.items = items;
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

    public double quantityOfItem(String name) {
        return items.stream().filter(item -> item.getItemName().equals(name)).count();
    }

    @Override
    public void calculateTotalPrice() {
        double sum =  items.stream().mapToDouble(item -> item.getPrice()).sum();
        totalPrice = sum - discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

}
