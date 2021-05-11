package com.ceiba.coffee.command.factory;

import com.ceiba.coffee.command.UpdateCoffeeCommand;
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
                Money.createUSD(registerCoffeeCommand.getValue()),
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
}
