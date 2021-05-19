package com.ceiba.coffee.adapter.dao;

import com.ceiba.coffee.model.dto.CoffeeDto;
import com.ceiba.coffee.model.entity.CoffeeCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeMap implements RowMapper<CoffeeDto> {

    @Override
    public CoffeeDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int categoryId = resultSet.getInt("category_id");
        int price = resultSet.getInt("price");
        int units = resultSet.getInt("units");
        CoffeeCategory category = CoffeeCategory.fromId(categoryId);

        return new CoffeeDto(
                id,
                name,
                categoryId,
                category.getDescription(),
                price,
                units);
    }

}
