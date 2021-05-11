package com.ceiba.coffee.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.coffee.port.dao.CoffeeDao;

import org.springframework.stereotype.Component;

import com.ceiba.coffee.model.dto.CoffeeDto;

@Component
public class CoffeeDaoMysql implements CoffeeDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="coffee", value="list")
    private static String listSql;

    public CoffeeDaoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<CoffeeDto> list() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(listSql, new CoffeeMap());
    }
}
