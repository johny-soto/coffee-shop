package com.ceiba.coffee.model.dto;

import com.ceiba.coffee.model.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CoffeeDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer price;
    private Integer units;


    public static CoffeeDto fromEntity(Coffee coffee){
        return new CoffeeDto(
                coffee.getId(),
                coffee.getName(),
                coffee.getCategory().getId(),
                coffee.getPrice().getAmount(),
                coffee.getUnits());
    }

}
