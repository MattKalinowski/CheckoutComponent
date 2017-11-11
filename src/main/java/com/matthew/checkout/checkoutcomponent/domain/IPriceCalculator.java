package com.matthew.checkout.checkoutcomponent.domain;


public interface IPriceCalculator {
    void determineDiscount();
    void calculateTotalPrice();
}
