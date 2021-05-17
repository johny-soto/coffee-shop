package com.ceiba.order.port.repository;


public interface CurrencyRateRepository {
    Double getTRM(String sourceCurrency, String targetCurrency);
}
