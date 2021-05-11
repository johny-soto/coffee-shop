package com.ceiba.coffee.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.coffee.model.dto.CoffeeDto;
import org.springframework.jdbc.core.RowMapper;

public class CoffeeMap implements RowMapper<CoffeeDto>, MapperResult {

    @Override
    public CoffeeDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer categoryId = resultSet.getInt("category_id");
        Integer price = resultSet.getInt("price");
        Integer units = resultSet.getInt("units");

        return new CoffeeDto(id,name,categoryId,price, units);
    }

}
