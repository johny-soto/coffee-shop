package com.ceiba.coffee.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.coffee.command.RegisterCoffeeCommand;
import com.ceiba.coffee.service.testdatabuilder.CoffeeCommandTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(CoffeeCommandController.class)
public class CoffeeCommandControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception{
        // arrange
        RegisterCoffeeCommand coffee = new CoffeeCommandTestDataBuilder().build();

        // act - assert
        mockMvc.perform(post("/coffees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coffee)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'value': 2}"));
    }

    @Test
    public void update() throws Exception{
        // arrange
        Integer id = 1;
        RegisterCoffeeCommand coffee = new CoffeeCommandTestDataBuilder().build();

        // act - assert
        mockMvc.perform(put("/coffees/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coffee)))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        // arrange
        Integer id = 2;

        // act - assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/coffees/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
