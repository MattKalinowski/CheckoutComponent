package com.matthew.checkout.checkoutcomponent.web;

import com.matthew.checkout.checkoutcomponent.domain.Item;
import com.matthew.checkout.checkoutcomponent.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckoutController {
    
    @Autowired
    private CheckoutService checkoutService;
    
    @GetMapping("/items")
    public List<Item> getItems() {
        return checkoutService.getItems();
    }
    
    @PostMapping("/items")
    public void addItem(@RequestBody Item item) {
        checkoutService.addItem(item);
    }

    @GetMapping("/price")
    public double getTotalPrice() {
        return checkoutService.getPrice();
    }

    
}
