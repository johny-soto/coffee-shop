package com.ceiba.coffee.service;

import com.ceiba.BaseTest;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.coffee.testdatabuilder.CoffeeTestDataBuilder;
import com.ceiba.domain.exception.NoDataException;
import org.junit.Test;
import org.mockito.Mockito;

public class UpdateCoffeeServiceTest {

    @Test
    public void validateCoffeeDoesNotExist() {
        // arrange
        Coffee coffee = new CoffeeTestDataBuilder().whitId(1).build();
        CoffeeRepository coffeeRepository = Mockito.mock(CoffeeRepository.class);
        Mockito.when(coffeeRepository.exist(Mockito.anyInt())).thenReturn(false);
        UpdateCoffeeService updateCoffeeService = new UpdateCoffeeService(coffeeRepository);
        // act - assert
        BaseTest.assertThrows(() -> updateCoffeeService.execute(coffee), NoDataException.class,"Café no encontrado");
    }
}
