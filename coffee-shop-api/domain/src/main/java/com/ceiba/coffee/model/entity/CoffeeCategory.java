package com.ceiba.coffee.model.entity;

import com.ceiba.domain.exception.InvalidValueException;

public class CoffeeCategory {
    private final int id;
    private final String description;

    public static final CoffeeCategory classic = new CoffeeCategory(1, "Clasico");
    public static final CoffeeCategory speciality = new CoffeeCategory(2, "Especialidad");

    private CoffeeCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static CoffeeCategory fromId(int id) {
        if (id == 1) {
            return classic;
        }
        if (id == 2) {
            return speciality;
        }
        throw new InvalidValueException("Categoria no valida");
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
