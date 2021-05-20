package com.ceiba.coffee.model.valueobject;

import com.ceiba.domain.exception.InvalidValueException;

import java.util.Objects;

public class Currency {
    public static final Currency USD = new Currency("USD");
    public static final Currency COP = new Currency("COP");

    private String isoCode;

    public Currency(String isoCode) {
        this.setIsoCode(isoCode);
    }

    public String getIsoCode() {
        return isoCode;
    }

    private void setIsoCode(String isoCode) {
        try {
            java.util.Currency.getInstance(isoCode);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidValueException("Codigo ISO no valido");
        }
        this.isoCode = isoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency currency = (Currency) o;
        return isoCode.equals(currency.isoCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isoCode);
    }
}
