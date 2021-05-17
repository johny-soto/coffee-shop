package com.ceiba.setting;

import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.coffee.service.DeleteCoffeeService;
import com.ceiba.coffee.service.RegisterCoffeeService;
import com.ceiba.coffee.service.UpdateCoffeeService;
import com.ceiba.order.port.repository.CurrencyRateRepository;
import com.ceiba.order.port.repository.OrderRepository;
import com.ceiba.order.service.CreateOrderService;
import com.ceiba.order.service.CurrencyConverterService;
import com.ceiba.order.service.PlaceOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanService {

    @Bean
    public RegisterCoffeeService registerCoffeeService(CoffeeRepository coffeeRepository) {
        return new RegisterCoffeeService(coffeeRepository);
    }

    @Bean
    public DeleteCoffeeService deleteCoffeeService(CoffeeRepository coffeeRepository) {
        return new DeleteCoffeeService(coffeeRepository);
    }

    @Bean
    public UpdateCoffeeService updateCoffeeService(CoffeeRepository coffeeRepository) {
        return new UpdateCoffeeService(coffeeRepository);
    }

    @Bean
    public CurrencyConverterService currencyConverterService(CurrencyRateRepository currencyRateRepository) {
        return new CurrencyConverterService(currencyRateRepository);
    }
    @Bean
    public CreateOrderService createOrderService(OrderRepository orderRepository) {
        return new CreateOrderService(orderRepository);
    }

    @Bean
    public PlaceOrderService placeOrderService(OrderRepository orderRepository) {
        return new PlaceOrderService(orderRepository);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
