package com.ceiba.coffee.testdatabuilder;

import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.model.entity.CoffeeCategory;
import com.ceiba.coffee.model.valueobject.Money;

import java.util.UUID;

public class CoffeeTestDataBuilder {

    private Integer id;
    private String name;
    private Integer category;
    private Integer price;
    private Integer units;

    public CoffeeTestDataBuilder() {
        id = 0;
        name = UUID.randomUUID().toString();
        category = 1;
        price = 10;
        units = 1;
    }


    public CoffeeTestDataBuilder whitId(Integer id) {
        this.id = id;
        return this;
    }

    public CoffeeTestDataBuilder whitName(String name) {
        this.name = name;
        return this;
    }

    public CoffeeTestDataBuilder whitCategory(Integer category) {
        this.category = category;
        return this;
    }

    public CoffeeTestDataBuilder whitUnits(Integer units) {
        this.units = units;
        return this;
    }

    public Coffee build() {

        return new Coffee(id, name, CoffeeCategory.fromId(category), Money.createUSD(price), units);
    }
}
