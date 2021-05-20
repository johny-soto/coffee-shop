package com.ceiba.coffee;

import com.ceiba.BaseTest;
import com.ceiba.coffee.testdatabuilder.CurrencyTestDataBuilder;
import com.ceiba.domain.exception.InvalidValueException;
import com.ceiba.domain.exception.NoDataException;
import org.junit.Test;

public class CurrencyTest {
    @Test
    public void validateInvalidISO() {
        // act - assert
        BaseTest.assertThrows(() -> new CurrencyTestDataBuilder().whitIsoCode("USDD").build(),
                InvalidValueException.class, "Codigo ISO no valido");
    }

    @Test
    public void validateNullISO() {
        // act - assert
        BaseTest.assertThrows(() -> new CurrencyTestDataBuilder().whitIsoCode(null).build(),
                NoDataException.class, "Debe proporcionar un codigo ISO");
    }
}
