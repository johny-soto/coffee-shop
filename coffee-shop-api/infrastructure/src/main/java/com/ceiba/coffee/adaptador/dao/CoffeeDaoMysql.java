package com.ceiba.coffee.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.coffee.port.dao.CoffeeDao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.coffee.model.dto.CoffeeDto;

@Component
public class CoffeeDaoMysql implements CoffeeDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "coffee", value = "list")
    private static String listSql;

    @SqlStatement(namespace = "coffee", value = "listByIds")
    private static String listByIdSql;

    public CoffeeDaoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<CoffeeDto> list() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(listSql, new CoffeeMap());
    }

    @Override
    public List<CoffeeDto> listByIds(List<Integer> ids) {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", ids);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(listByIdSql,
                parameters, new CoffeeMap());

    }
}
