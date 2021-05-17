package com.ceiba.order.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.order.command.CreateOrderCommand;
import com.ceiba.order.command.PlaceOrderCommand;
import com.ceiba.order.model.dto.OrderDto;
import com.ceiba.order.port.dao.OrderDao;
import com.ceiba.order.testdatabuilder.OrderCommandTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(OrderCommandController.class)
public class OrderCommandControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void create() throws Exception {
        // arrange
        CreateOrderCommand order = new OrderCommandTestDataBuilder().build();

        // act - assert
        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 2}"));
        OrderDto orderDto = orderDao.getById(1);

        Assert.assertEquals(orderDto.getTotal(), 10, 0);

    }

    @Test
    public void placeOrder() throws Exception {
        // arrange
        PlaceOrderCommand order = new PlaceOrderCommand(1);

        // act - assert
        mockMvc.perform(put("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());

        OrderDto orderDto = orderDao.getById(1);

        Assert.assertEquals(orderDto.getTotal(), 10, 0);

    }
}
