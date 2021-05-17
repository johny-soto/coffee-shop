package com.ceiba.order.adapter.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.order.model.dto.OrderDto;
import com.ceiba.order.port.dao.OrderDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class OrderDaoMysql implements OrderDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "order", value = "get")
    private static String getSql;


    public OrderDaoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public OrderDto getById(Integer orderId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", orderId);
        return this.customNamedParameterJdbcTemplate.
                getNamedParameterJdbcTemplate().
                queryForObject(getSql, paramSource, new OrderMap());
    }
}
