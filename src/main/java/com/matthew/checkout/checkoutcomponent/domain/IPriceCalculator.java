package com.matthew.checkout.checkoutcomponent.domain;


public interface IPriceCalculator {
    double quantityOfItem(String name);
    void determineDiscount();
    void calculateTotalPrice();
}
