package com.ceiba.coffee;

import com.ceiba.BaseTest;
import com.ceiba.coffee.testdatabuilder.CoffeeTestDataBuilder;
import com.ceiba.domain.exception.InvalidValueException;
import com.ceiba.domain.exception.ValueRequiredException;
import org.junit.Test;

public class CoffeeTest {

    @Test
    public void validateCoffeeNullName() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitName(null).build(),
                ValueRequiredException.class, "El nombre es requerido");
    }

    @Test
    public void validateCoffeeEmptyName() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitName("").build(),
                ValueRequiredException.class, "El nombre no puede estar vacio");
    }

    @Test
    public void validateCoffeePositiveUnits() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitUnits(0).build(),
                InvalidValueException.class, "Las unidades deben ser mayor a 0");
    }

    @Test
    public void validateCoffeeCategory() {
        // act - assert
        BaseTest.assertThrows(() -> new CoffeeTestDataBuilder().whitCategory(3).build(),
                InvalidValueException.class, "Categoria no valida");
    }
}
