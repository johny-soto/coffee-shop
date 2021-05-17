package com.ceiba.order.command.handler;

import com.ceiba.handler.CommandHandler;
import com.ceiba.order.command.PlaceOrderCommand;
import com.ceiba.order.service.PlaceOrderService;
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
