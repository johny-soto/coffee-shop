package com.ceiba.coffee.model.entity;


import com.ceiba.coffee.model.valueobject.Money;
import lombok.Getter;

@Getter
public class Coffee {

    private int id;
    private String name;
    private CoffeeCategory category;
    private Money price;
    private int units;

    public Coffee(int id, String name, CoffeeCategory category, Money price, int units) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.units = units;
    }

    public Coffee(String name, CoffeeCategory category, Money price, int units) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.units = units;
    }
}
