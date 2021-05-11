package com.ceiba.coffee.service.testdatabuilder;

import com.ceiba.coffee.command.RegisterCoffeeCommand;

import java.util.UUID;

public class CoffeeCommandTestDataBuilder {

    private Integer id;
    private String name;
    private Integer category;
    private Integer price;
    private Integer units;

    public CoffeeCommandTestDataBuilder() {
        name = UUID.randomUUID().toString();
        category = 1;
        price = 10;
        units = 1;
    }


    public RegisterCoffeeCommand build() {
        return new RegisterCoffeeCommand(name, category,price, units);
    }
}
