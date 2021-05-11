package com.ceiba.coffee.service;

import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.coffee.service.testdatabuilder.CoffeeTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterCoffeeServiceTest {


    @Test
    public void validateCreateCoffee() {
        // arrange
        Coffee coffee = new CoffeeTestDataBuilder().build();
        CoffeeRepository coffeeRepository = Mockito.mock(CoffeeRepository.class);
        Mockito.when(coffeeRepository.create(Mockito.anyObject())).thenReturn(1);
        RegisterCoffeeService registerCoffeeService = new RegisterCoffeeService(coffeeRepository);
        // act - assert
        assertEquals(1, (int) registerCoffeeService.execute(coffee));
    }
}
