package com.ceiba.coffee.model.entity;

public class CoffeeCategory {
    private int id;
    private String description;

    public final static CoffeeCategory classic = new CoffeeCategory(1,"Clasico");
    public final static CoffeeCategory speciality = new CoffeeCategory(2,"Especialidad");

    private CoffeeCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static CoffeeCategory fromId(int id){
        if (id == 1){
            return classic;
        }
        if (id == 2) {
            return speciality;
        }
        throw new IllegalArgumentException();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
