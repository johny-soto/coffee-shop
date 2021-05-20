package com.ceiba.coffee.model.dto;

import com.ceiba.coffee.model.entity.Coffee;

public class CoffeeDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String categoryDescription;
    private Integer price;
    private Integer units;


    public static CoffeeDto fromEntity(Coffee coffee) {
        return new CoffeeDto(
                coffee.getId(),
                coffee.getName(),
                coffee.getCategory().getId(),
                coffee.getCategory().getDescription(),
                (int) coffee.getPrice().getAmount(),
                coffee.getUnits());
    }

    public CoffeeDto(Integer id, String name, Integer categoryId, String categoryDescription, Integer price, Integer units) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.categoryDescription = categoryDescription;
        this.price = price;
        this.units = units;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getUnits() {
        return units;
    }
}
