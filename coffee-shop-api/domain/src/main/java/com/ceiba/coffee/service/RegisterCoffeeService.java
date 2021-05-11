package com.ceiba.coffee.service;

import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.port.repository.CoffeeRepository;


public class RegisterCoffeeService {

    private final CoffeeRepository coffeeRepository;

    public RegisterCoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Integer execute(Coffee coffee) {
        return this.coffeeRepository.create(coffee);
    }

}
