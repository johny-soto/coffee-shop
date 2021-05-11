package com.ceiba.coffee.controller;

import java.util.List;

import com.ceiba.coffee.query.ListCoffeeQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.coffee.model.dto.CoffeeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coffees")
@Api(tags={"Controlador consulta café"})
public class CoffeeQueryController {

    private final ListCoffeeQuery listCoffeeQuery;

    public CoffeeQueryController(ListCoffeeQuery listCoffeeQuery) {
        this.listCoffeeQuery = listCoffeeQuery;
    }

    @GetMapping
    @ApiOperation("Listar Cafés")
    public List<CoffeeDto> list() {
        return this.listCoffeeQuery.execute();
    }

}
