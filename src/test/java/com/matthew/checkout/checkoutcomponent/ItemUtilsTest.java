package com.matthew.checkout.checkoutcomponent;

import org.junit.Test;

import static com.matthew.checkout.checkoutcomponent.domain.ItemUtils.*;
import static org.junit.Assert.assertEquals;

public class ItemUtilsTest {

    @Test
    public void returnItemPriceTest() {
        double returnedPrice = returnItemPrice("A");
        double expectedPrice = 25.0;
        assertEquals(expectedPrice, returnedPrice, 0);
    }

    @Test
    public void returnItemDiscountTest() {
        double returnedDiscount = returnItemDiscount("A");
        double expectedDiscount = 2.0;
        assertEquals(expectedDiscount, returnedDiscount, 0);
    }

}
