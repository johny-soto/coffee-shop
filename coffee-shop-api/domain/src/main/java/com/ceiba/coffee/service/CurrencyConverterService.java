package com.ceiba.coffee.service;

import com.ceiba.coffee.model.valueobject.Currency;
import com.ceiba.coffee.model.valueobject.Money;
import com.ceiba.coffee.port.repository.CurrencyRateRepository;

public class CurrencyConverterService {

    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyConverterService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public Money convert(Money money, Currency currency){
        Double trm = currencyRateRepository.getTRM(money.getCurrency().getIsoCode(), currency.getIsoCode());
        return new Money((int)(money.getAmount() * trm), currency);
    }
}
