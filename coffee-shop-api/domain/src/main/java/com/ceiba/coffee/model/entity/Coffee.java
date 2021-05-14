package com.ceiba.coffee.model.entity;


import com.ceiba.coffee.model.valueobject.Money;
import com.ceiba.domain.ArgumentValidator;
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
        setName(name);
        this.category = category;
        this.price = price;
        setUnits(units);
    }

    public Coffee(String name, CoffeeCategory category, Money price, int units) {
        setName(name);
        this.category = category;
        this.price = price;
        setUnits(units);
    }

    public Coffee(int id) {
        this.id = id;
    }

    private void setUnits(int units) {
        ArgumentValidator.validatePositive(units, "Las unidades deben ser mayor a 0");
        this.units = units;
    }

    private void setName(String name) {
        ArgumentValidator.validateRequired(name, "El nombre es requerido");
        ArgumentValidator.validateNotEmpty(name, "El nombre no puede estar vacio");
        this.name = name;
    }
}
