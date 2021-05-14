package com.ceiba.coffee.command.handler;

import com.ceiba.CommandResponse;
import com.ceiba.coffee.command.CreateOrderCommand;
import com.ceiba.coffee.command.factory.CoffeeFactory;
import com.ceiba.coffee.model.dto.CoffeeDto;
import com.ceiba.coffee.model.dto.OrderDto;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.model.entity.Order;
import com.ceiba.coffee.model.valueobject.Currency;
import com.ceiba.coffee.port.dao.CoffeeDao;
import com.ceiba.coffee.service.CreateOrderService;
import com.ceiba.coffee.service.CurrencyConverterService;
import com.ceiba.handler.CommandHandlerWithResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.ceiba.coffee.model.valueobject.Currency.COP;
import static com.ceiba.coffee.model.valueobject.Currency.USD;

@Component
public class CreateOrderHandler implements CommandHandlerWithResponse<CreateOrderCommand, CommandResponse<OrderDto>> {

    private final CurrencyConverterService currencyConverterService;
    private final CoffeeDao coffeeDao;
    private final CoffeeFactory coffeeFactory;
    private final CreateOrderService createOrderService;

    public CreateOrderHandler(CurrencyConverterService currencyConverterService, CoffeeDao coffeeDao, CoffeeFactory coffeeFactory, CreateOrderService createOrderService) {
        this.currencyConverterService = currencyConverterService;
        this.coffeeDao = coffeeDao;
        this.coffeeFactory = coffeeFactory;
        this.createOrderService = createOrderService;
    }

    @Override
    public CommandResponse<OrderDto> execute(CreateOrderCommand command) {
        List<CoffeeDto> coffeesDto = coffeeDao.listByIds(command.getCoffees());
        List<Coffee> coffees = coffeesDto.stream().map(coffeeFactory::create).collect(Collectors.toList());
        Order order = new Order(coffees, new Currency(command.getCurrency()));
        int orderId = this.createOrderService.execute(order);
        if (order.getCurrency().equals(USD)){
            return new CommandResponse<>(OrderDto.fromEntity(order, orderId));
        }
        return new CommandResponse<>(orderToOrderDtoCOPPrices(order, orderId));
    }

    private OrderDto orderToOrderDtoCOPPrices(Order order, int orderId) {
        return new OrderDto(
                orderId,
                (int)currencyConverterService.convert(order.getOrderGrossPrice(), COP)
                        .getAmount(),
                currencyConverterService.convert(order.getOrderDiscount(), COP)
                        .getAmount(),
                currencyConverterService.convert(order.getCharges(), COP)
                        .getAmount(),
                currencyConverterService.convert(order.getTotal(), COP)
                        .getAmount(),
                order.getDate());
    }
}
