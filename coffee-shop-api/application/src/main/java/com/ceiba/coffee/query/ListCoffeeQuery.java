package com.ceiba.coffee.query;

import java.util.List;

import com.ceiba.coffee.port.dao.CoffeeDao;
import org.springframework.stereotype.Component;

import com.ceiba.coffee.model.dto.CoffeeDto;

@Component
public class ListCoffeeQuery {

    private final CoffeeDao coffeeDao;

    public ListCoffeeQuery(CoffeeDao coffeeDao){
        this.coffeeDao = coffeeDao;
    }

    public List<CoffeeDto> execute(){ return this.coffeeDao.list(); }
}
