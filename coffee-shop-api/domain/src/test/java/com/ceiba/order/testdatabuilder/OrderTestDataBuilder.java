package com.ceiba.order.testdatabuilder;


import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.model.valueobject.Currency;
import com.ceiba.coffee.testdatabuilder.CoffeeTestDataBuilder;
import com.ceiba.order.model.entity.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTestDataBuilder {

    private String currency;
    private List<Coffee> coffees;
    private Date date;
//    private Double orderGrossPrice;
//    private Double orderDiscount;
//    private Double charges;
//    private Double total;
//    private Date date;

    public OrderTestDataBuilder() {
        Coffee coffee = new CoffeeTestDataBuilder().whitId(1).build();
        currency = "USD";
        coffees = new ArrayList<>();
        coffees.add(coffee);
        date = new Date();
    }

    public OrderTestDataBuilder whitCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
        return this;
    }

    public OrderTestDataBuilder whitCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public OrderTestDataBuilder whitDate(Date date) {
        this.date = date;
        return this;
    }

    public Order build() {

        return new Order(coffees, new Currency(currency), date);
    }
}
