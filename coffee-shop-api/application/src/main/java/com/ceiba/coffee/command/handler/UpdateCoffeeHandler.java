package com.ceiba.coffee.command.handler;

import com.ceiba.coffee.command.UpdateCoffeeCommand;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.service.UpdateCoffeeService;
import com.ceiba.handler.CommandHandler;
import org.springframework.stereotype.Component;

import com.ceiba.coffee.command.factory.CoffeeFactory;

@Component
public class UpdateCoffeeHandler implements CommandHandler<UpdateCoffeeCommand> {

    private final CoffeeFactory coffeeFactory;
    private final UpdateCoffeeService updateCoffeeService;

    public UpdateCoffeeHandler(CoffeeFactory coffeeFactory, UpdateCoffeeService updateCoffeeService) {
        this.coffeeFactory = coffeeFactory;
        this.updateCoffeeService = updateCoffeeService;
    }

    public void execute(UpdateCoffeeCommand command) {
        Coffee coffee = this.coffeeFactory.create(command);
        this.updateCoffeeService.execute(coffee);
    }
}
