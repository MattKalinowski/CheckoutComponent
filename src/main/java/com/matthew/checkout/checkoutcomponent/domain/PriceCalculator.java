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

        double quantityOfItemA = items.stream().filter(item -> item.getItemName().equals("A")).count();
        double quantityOfItemB = items.stream().filter(item -> item.getItemName().equals("B")).count();
        double quantityOfItemC = items.stream().filter(item -> item.getItemName().equals("C")).count();
        double quantityOfItemD = items.stream().filter(item -> item.getItemName().equals("D")).count();

        if (quantityOfItemA > 14) {
            discount = discount + (quantityOfItemA * returnItemDiscount("A"));
        }
        if (quantityOfItemB > 9) {
            discount = discount + (quantityOfItemB * returnItemDiscount("B"));
        }
        if (quantityOfItemC > 7) {
            discount = discount + (quantityOfItemC * returnItemDiscount("C"));
        }
        if (quantityOfItemD > 4) {
            discount = discount + (quantityOfItemD * returnItemDiscount("D"));
        }
    }

    @Override
    public void calculateTotalPrice() {
        double sum =  items.stream().mapToDouble(item -> item.getPrice()).sum();
        totalPrice = sum - discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}
