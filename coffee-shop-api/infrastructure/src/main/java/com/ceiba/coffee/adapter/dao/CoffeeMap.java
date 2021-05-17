package com.ceiba.coffee.adapter.dao;

import com.ceiba.coffee.model.dto.CoffeeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeMap implements RowMapper<CoffeeDto> {

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
