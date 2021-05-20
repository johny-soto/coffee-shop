package com.ceiba.coffee.testdatabuilder;

import com.ceiba.coffee.model.valueobject.Currency;

public class CurrencyTestDataBuilder {

    private String isoCode;

    public CurrencyTestDataBuilder() {
        isoCode = "USD";
    }


    public CurrencyTestDataBuilder whitIsoCode(String isoCode) {
        this.isoCode = isoCode;
        return this;
    }

    public Currency build() {

        return new Currency(isoCode);
    }
}
