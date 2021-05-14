package com.ceiba.coffee.command.factory;

import com.ceiba.coffee.command.UpdateCoffeeCommand;
import com.ceiba.coffee.model.dto.CoffeeDto;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.model.entity.CoffeeCategory;
import com.ceiba.coffee.model.valueobject.Money;
import org.springframework.stereotype.Component;

import com.ceiba.coffee.command.RegisterCoffeeCommand;

@Component
public class CoffeeFactory {

    public Coffee create(RegisterCoffeeCommand registerCoffeeCommand) {
        return new Coffee(
                registerCoffeeCommand.getName(),
                CoffeeCategory.fromId(registerCoffeeCommand.getCategory()),
                Money.createUSD(registerCoffeeCommand.getPrice()),
                registerCoffeeCommand.getUnits()
        );
    }

    public Coffee create(UpdateCoffeeCommand updateCoffeeCommand) {
        return new Coffee(
                updateCoffeeCommand.getId(),
                updateCoffeeCommand.getName(),
                CoffeeCategory.fromId(updateCoffeeCommand.getCategory()),
                Money.createUSD(updateCoffeeCommand.getValue()),
                updateCoffeeCommand.getUnits()
        );
    }

    public Coffee create(CoffeeDto coffeeDto) {
        return new Coffee(
                coffeeDto.getId(),
                coffeeDto.getName(),
                CoffeeCategory.fromId(coffeeDto.getCategoryId()),
                Money.createUSD(coffeeDto.getPrice()),
                coffeeDto.getUnits()
        );
    }
}
