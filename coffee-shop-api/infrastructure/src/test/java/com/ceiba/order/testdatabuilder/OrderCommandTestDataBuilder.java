package com.ceiba.order.testdatabuilder;

import com.ceiba.order.command.CreateOrderCommand;

import java.util.ArrayList;
import java.util.List;

public class OrderCommandTestDataBuilder {

    private List<Integer> coffees;
    private String currency;

    public OrderCommandTestDataBuilder() {
        coffees = new ArrayList<>() {{
            add(1);
        }};
        currency = "USD";
    }

    public OrderCommandTestDataBuilder whitCurrency(String currency) {
        this.currency = currency;
        return this;
    }


    public CreateOrderCommand build() {
        return new CreateOrderCommand(coffees, currency);
    }
}
