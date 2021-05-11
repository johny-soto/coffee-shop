package com.ceiba.coffee.service;

import com.ceiba.coffee.exception.CoffeeNotFoundException;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.coffee.service.testdatabuilder.CoffeeTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BaseTest;

public class UpdateCoffeeServiceTest {

    @Test
    public void validateCoffeeDoesNotExist() {
        // arrange
        Coffee coffee = new CoffeeTestDataBuilder().whitId(1).build();
        CoffeeRepository coffeeRepository = Mockito.mock(CoffeeRepository.class);
        Mockito.when(coffeeRepository.exist(Mockito.anyInt())).thenReturn(false);
        UpdateCoffeeService updateCoffeeService = new UpdateCoffeeService(coffeeRepository);
        // act - assert
        BaseTest.assertThrows(() -> updateCoffeeService.execute(coffee), CoffeeNotFoundException.class,"Café no encontrado");
    }
}
