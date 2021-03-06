package com.junit.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void dummyItem_basic() throws Exception {
    RequestBuilder request =
        MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
        .andExpect(content().string("{\"id\":1,\"name\":\"Avinash\",\"price\":10,\"quantity\":14}"))
        .andReturn();

    MvcResult resultJson = mockMvc.perform(request).andExpect(status().isOk())
        .andExpect(content().json("{\"id\":1,\"name\":\"Avinash\",\"price\":10,\"quantity\":14}"))
        .andReturn();

    MvcResult resultJson1 = mockMvc.perform(request).andExpect(status().isOk())
        .andExpect(content().json("{\"id\":1,\"name\":\"Avinash\",\"price\":10}")).andReturn();


  }
}
