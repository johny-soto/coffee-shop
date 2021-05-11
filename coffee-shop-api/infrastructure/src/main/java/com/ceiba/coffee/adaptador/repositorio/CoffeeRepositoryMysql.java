package com.ceiba.coffee.adaptador.repositorio;

import com.ceiba.coffee.model.dto.CoffeeDto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.port.repository.CoffeeRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CoffeeRepositoryMysql implements CoffeeRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="coffee", value="create")
    private static String createSql;

    @SqlStatement(namespace="coffee", value="update")
    private static String updateSql;

    @SqlStatement(namespace="coffee", value="delete")
    private static String deleteSql;

    @SqlStatement(namespace="coffee", value="exist")
    private static String existSql;


    public CoffeeRepositoryMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer create(Coffee coffee) {
        return this.customNamedParameterJdbcTemplate.create(CoffeeDto.fromEntity(coffee), createSql);
    }

    @Override
    public void delete(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(deleteSql, paramSource);
    }

    @Override
    public boolean exist(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.
                    getNamedParameterJdbcTemplate().
                    queryForObject(existSql, paramSource, Boolean.class);
    }

    @Override
    public void update(Coffee coffee) {
        this.customNamedParameterJdbcTemplate.update(CoffeeDto.fromEntity(coffee), updateSql);
    }

}
