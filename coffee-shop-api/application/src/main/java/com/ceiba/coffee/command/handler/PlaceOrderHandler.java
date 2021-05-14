package com.ceiba.coffee.command.handler;

import com.ceiba.coffee.command.PlaceOrderCommand;
import com.ceiba.coffee.service.PlaceOrderService;
import com.ceiba.handler.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class PlaceOrderHandler implements CommandHandler<PlaceOrderCommand> {

    private final PlaceOrderService placeOrderService;

    public PlaceOrderHandler(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    @Override
    public void execute(PlaceOrderCommand command) {
        placeOrderService.execute(command.getOrderId());
    }
}
