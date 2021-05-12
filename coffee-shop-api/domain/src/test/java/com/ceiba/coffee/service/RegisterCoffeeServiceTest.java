package com.ceiba.coffee.service;

import com.ceiba.BaseTest;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.coffee.service.testdatabuilder.CoffeeTestDataBuilder;
import com.ceiba.domain.exception.InvalidValueException;
import com.ceiba.domain.exception.NoDataException;
import com.ceiba.domain.exception.ValueRequiredException;
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

    @Test
    public void validateCoffeeNullName() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitName(null).build(),
                ValueRequiredException.class,"El nombre es requerido");
    }

    @Test
    public void validateCoffeeEmptyName() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitName("").build(),
                ValueRequiredException.class,"El nombre no puede estar vacio");
    }

    @Test
    public void validateCoffeePositiveUnits() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitUnits(0).build(),
                InvalidValueException.class,"Las unidades deben ser mayor a 0");
    }
}
