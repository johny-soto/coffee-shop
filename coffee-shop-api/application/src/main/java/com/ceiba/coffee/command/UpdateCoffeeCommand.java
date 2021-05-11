package com.ceiba.coffee.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCoffeeCommand {

    private int id;
    private String name;
    private int category;
    private int units;
    private int value;
}
