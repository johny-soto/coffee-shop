package com.ceiba.coffee.adaptador.repositorio;

import com.ceiba.coffee.model.dto.OrderDto;
import com.ceiba.coffee.model.entity.Order;
import com.ceiba.coffee.port.repository.OrderRepository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlOrderRepository implements OrderRepository {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "sql.order", value = "create")
    private static String createSql;

    @SqlStatement(namespace = "sql.order", value = "place")
    private static String placeSql;

    @SqlStatement(namespace = "sql.order", value = "exist")
    private static String existSql;

    public MysqlOrderRepository(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer create(Order order) {
        return this.customNamedParameterJdbcTemplate
                .create(OrderDto.fromEntity(order), createSql);
    }

    @Override
    public void place(Integer orderId) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", orderId);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(placeSql,parameters);
    }

    @Override
    public boolean exist(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.
                getNamedParameterJdbcTemplate().
                queryForObject(existSql, paramSource, Boolean.class);
    }
}
