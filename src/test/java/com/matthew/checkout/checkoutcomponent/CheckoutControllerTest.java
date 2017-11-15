package com.matthew.checkout.checkoutcomponent;

import com.matthew.checkout.checkoutcomponent.domain.Item;
import com.matthew.checkout.checkoutcomponent.domain.PriceCalculator;
import com.matthew.checkout.checkoutcomponent.service.CheckoutService;
import com.matthew.checkout.checkoutcomponent.web.CheckoutController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CheckoutController.class)
public class CheckoutControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CheckoutService service;

    private Item item;
    private List<Item> items;

    @Before

    public void setup() {
        item = new Item();
        item.setItemName("A");
        items = Arrays.asList(item);
    }

    @Test
    public void getItemsTest() throws Exception {
        given(service.getItems()).willReturn(items);
        mvc.perform(get("/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(content().string(org.hamcrest.Matchers.containsString(
                        "[{\"itemId\":0,\"itemName\":\"A\",\"price\":0.0}]")));

    }

    @Test
    public void addItemTest() throws Exception {
         mvc.perform(post("/items")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(new Item().toString().getBytes()))
                 .andExpect(mvcResult -> status().isOk());
    }

    @Test
    public void getTotalPriceTest() throws Exception {
        PriceCalculator calc = new PriceCalculator(items);
        given(service.getPrice()).willReturn(calc);
        mvc.perform(get("/items/price")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString(
                        "{\"totalPrice\":0.0,\"discount\":0.0}")));
    }

    @Test
    public void removeItemTest() throws Exception {
        mvc.perform(delete("/items/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void removeAllItemsTest() throws Exception {
        mvc.perform(delete("/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
