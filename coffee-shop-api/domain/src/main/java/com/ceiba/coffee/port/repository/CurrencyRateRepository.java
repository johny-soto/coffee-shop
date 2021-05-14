package com.ceiba.coffee.port.repository;


public interface CurrencyRateRepository {
    Double getTRM(String sourceCurrency, String targetCurrency);
}
