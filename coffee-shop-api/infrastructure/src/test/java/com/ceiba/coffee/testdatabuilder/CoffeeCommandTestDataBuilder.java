package com.ceiba.coffee.testdatabuilder;

import com.ceiba.coffee.command.RegisterCoffeeCommand;

public class CoffeeCommandTestDataBuilder {

    private Integer id;
    private String name;
    private Integer category;
    private Integer price;
    private Integer units;

    public CoffeeCommandTestDataBuilder() {
        name = "Test";
        category = 1;
        price = 10;
        units = 1;
    }


    public RegisterCoffeeCommand build() {
        return new RegisterCoffeeCommand(name, category,price, units);
    }
}
