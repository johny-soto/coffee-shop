package com.ceiba.coffee.command.handler;

import com.ceiba.coffee.service.DeleteCoffeeService;
import com.ceiba.handler.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteCoffeeHandler implements CommandHandler<Integer> {

    private final DeleteCoffeeService deleteCoffeeService;

    public DeleteCoffeeHandler(DeleteCoffeeService deleteCoffeeService) {
        this.deleteCoffeeService = deleteCoffeeService;
    }

    public void execute(Integer command) {
        this.deleteCoffeeService.execute(command);
    }
}
