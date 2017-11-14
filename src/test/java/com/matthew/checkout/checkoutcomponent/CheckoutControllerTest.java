package com.matthew.checkout.checkoutcomponent;

import com.matthew.checkout.checkoutcomponent.domain.Item;
import com.matthew.checkout.checkoutcomponent.service.CheckoutService;
import com.matthew.checkout.checkoutcomponent.web.CheckoutController;
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

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    @Test
    public void getItemsTest() throws Exception {
        Item item = new Item();
        item.setItemName("A");
        List<Item> items = Arrays.asList(item);
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


    }

}
