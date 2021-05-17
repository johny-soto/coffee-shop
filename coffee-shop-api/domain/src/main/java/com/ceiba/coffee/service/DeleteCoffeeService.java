package com.ceiba.coffee.service;

import com.ceiba.coffee.port.repository.CoffeeRepository;
import com.ceiba.domain.exception.NoDataException;

public class DeleteCoffeeService {

    private static final String COFFEE_NOT_FOUND = "Café no encontrado";

    private final CoffeeRepository coffeeRepository;

    public DeleteCoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void execute(int id) {
        validateExistence(id);
        this.coffeeRepository.delete(id);
    }

    private void validateExistence(int id) {
        boolean exist = this.coffeeRepository.exist(id);
        if(!exist) {
            throw new NoDataException(COFFEE_NOT_FOUND);
        }
    }
}
