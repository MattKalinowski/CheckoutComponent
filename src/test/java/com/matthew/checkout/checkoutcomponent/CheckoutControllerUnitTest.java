package com.matthew.checkout.checkoutcomponent;

import com.matthew.checkout.checkoutcomponent.service.CheckoutService;
import com.matthew.checkout.checkoutcomponent.web.CheckoutController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CheckoutController.class)
public class CheckoutControllerUnitTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private CheckoutService service;
    /**
     *
    @Test
    public void getItemTest() throws Exception {
        given(service.getItem()).willReturn(new Item());
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"itemId\":null"
                        + ",\"price\":0.0,\"quantity\":0.0,\"totalPrice\":0.0}"));
    }
    
    @Test
    public void updateItemTest() throws Exception {
        doNothing().when(service).updateItem(new Item(), "A");
        mvc.perform(put("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"itemId\":null"
                        + ",\"price\":0.0,\"quantity\":0.0,\"totalPrice\":0.0}"))
                .andExpect(status().isOk());
    }

    */
}