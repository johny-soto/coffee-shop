package com.ceiba.setting;

import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.coffee.service.UpdateCoffeeService;
import com.ceiba.coffee.service.RegisterCoffeeService;
import com.ceiba.coffee.service.DeleteCoffeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	

}
