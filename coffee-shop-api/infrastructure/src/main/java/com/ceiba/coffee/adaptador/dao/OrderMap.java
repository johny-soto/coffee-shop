package com.ceiba.coffee.adaptador.dao;

import com.ceiba.coffee.model.dto.OrderDto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderMap implements RowMapper<OrderDto>, MapperResult {

    @Override
    public OrderDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer id = resultSet.getInt("id");
        Integer grossPrice = resultSet.getInt("gross_price");
        Double discount = resultSet.getDouble("discount");
        Double charges = resultSet.getDouble("charges");
        Double total = resultSet.getDouble("total");
        Date date = resultSet.getDate("date");

        return new OrderDto(id,grossPrice,discount,charges, total, date);
    }

}
