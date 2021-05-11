package com.ceiba.coffee.command.handler;

import com.ceiba.CommandResponse;
import com.ceiba.handler.CommandHandlerWithResponse;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.service.RegisterCoffeeService;
import org.springframework.stereotype.Component;

import com.ceiba.coffee.command.RegisterCoffeeCommand;
import com.ceiba.coffee.command.factory.CoffeeFactory;

@Component
public class RegisterCoffeeHandlerWithResponse implements CommandHandlerWithResponse<RegisterCoffeeCommand, CommandResponse<Integer>> {

    private final CoffeeFactory coffeeFactory;
    private final RegisterCoffeeService registerCoffeeService;

    public RegisterCoffeeHandlerWithResponse(CoffeeFactory coffeeFactory, RegisterCoffeeService registerCoffeeService) {
        this.coffeeFactory = coffeeFactory;
        this.registerCoffeeService = registerCoffeeService;
    }

    public CommandResponse<Integer> execute(RegisterCoffeeCommand command) {
        Coffee coffee = this.coffeeFactory.create(command);
        return new CommandResponse<>(this.registerCoffeeService.execute(coffee));
    }
}
