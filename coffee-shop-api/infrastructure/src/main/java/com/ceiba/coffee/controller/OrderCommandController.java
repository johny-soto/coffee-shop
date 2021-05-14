package com.ceiba.coffee.controller;

import com.ceiba.coffee.command.CreateOrderCommand;
import com.ceiba.coffee.command.PlaceOrderCommand;
import com.ceiba.coffee.command.handler.CreateOrderHandler;
import com.ceiba.coffee.command.handler.PlaceOrderHandler;
import com.ceiba.coffee.model.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Api(tags = { "Controlador comando orden"})
public class OrderCommandController {

    private final CreateOrderHandler createOrderHandler;
    private final PlaceOrderHandler placeOrderHandler;

    public OrderCommandController(CreateOrderHandler createOrderHandler, PlaceOrderHandler placeOrderHandler) {
        this.createOrderHandler = createOrderHandler;
        this.placeOrderHandler = placeOrderHandler;
    }

    @PostMapping
    @ApiOperation("Crear pedido")
    public OrderDto create(@RequestBody CreateOrderCommand orderCommand) {
        return createOrderHandler.execute(orderCommand).getValue();
    }

    @PutMapping
    @ApiOperation("Realizar pedido")
    public void place(@RequestBody PlaceOrderCommand placeOrderCommand) {
        placeOrderHandler.execute(placeOrderCommand);
    }
}
