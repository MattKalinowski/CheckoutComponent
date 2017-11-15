package com.matthew.checkout.checkoutcomponent.service;

import com.matthew.checkout.checkoutcomponent.domain.ItemRepository;
import com.matthew.checkout.checkoutcomponent.domain.PriceCalculator;
import com.matthew.checkout.checkoutcomponent.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {

    @Autowired
    private ItemRepository itemRepository;
    
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll()
                .forEach(items::add);
        return items;
    }
    
    public void addItem(Item item) {
        item.setPrice();
        itemRepository.save(item);
    }

    public PriceCalculator getPrice() {
        PriceCalculator calc = new PriceCalculator(getItems());
        calc.determineDiscount();
        calc.calculateTotalPrice();
        return calc;
    }

    public void deleteItem(long itemId) {
        Item item = new Item();
        item.setItemId(itemId);
        itemRepository.delete(item);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
