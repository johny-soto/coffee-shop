package com.ceiba.coffee.controller;

import com.ceiba.CommandResponse;
import com.ceiba.coffee.command.RegisterCoffeeCommand;
import com.ceiba.coffee.command.UpdateCoffeeCommand;
import com.ceiba.coffee.command.handler.UpdateCoffeeHandler;
import com.ceiba.coffee.command.handler.RegisterCoffeeHandlerWithResponse;
import com.ceiba.coffee.command.handler.DeleteCoffeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coffees")
@Api(tags = { "Controlador comando café"})
public class CoffeeCommandController {

    private final RegisterCoffeeHandlerWithResponse registerCoffeeHandler;
	private final DeleteCoffeeHandler deleteCoffeeHandler;
	private final UpdateCoffeeHandler updateCoffeeHandler;

    @Autowired
    public CoffeeCommandController(RegisterCoffeeHandlerWithResponse registerCoffeeHandler,
								   DeleteCoffeeHandler deleteCoffeeHandler,
								   UpdateCoffeeHandler updateCoffeeHandler) {
        this.registerCoffeeHandler = registerCoffeeHandler;
		this.deleteCoffeeHandler = deleteCoffeeHandler;
		this.updateCoffeeHandler = updateCoffeeHandler;
    }

    @PostMapping
    @ApiOperation("Crear Café")
    public CommandResponse<Integer> create(@RequestBody RegisterCoffeeCommand registerCoffeeCommand) {
        return registerCoffeeHandler.execute(registerCoffeeCommand);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Café")
	public void delete(@PathVariable Integer id) {
		deleteCoffeeHandler.execute(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Café")
	public void update(@RequestBody UpdateCoffeeCommand updateCoffeeCommand, @PathVariable Integer id) {
		updateCoffeeCommand.setId(id);
		updateCoffeeHandler.execute(updateCoffeeCommand);
	}
}
