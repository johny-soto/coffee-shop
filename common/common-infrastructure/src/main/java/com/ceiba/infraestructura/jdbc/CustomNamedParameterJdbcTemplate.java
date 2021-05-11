package com.ceiba.infraestructura.jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

import com.ceiba.infraestructura.exception.TechnicalException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomNamedParameterJdbcTemplate {

	private static final String ERROR_GETTING_THE_OBJECT_NAME_AND_VALUE = "Error obteniendo el nombre y valor de objeto";
	
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public CustomNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public Integer create(Object object, String sql) {
		MapSqlParameterSource paramSource = createParameters(object);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.namedParameterJdbcTemplate.update(sql, paramSource,keyHolder,new String[] { "id" });
		return Objects.requireNonNull(keyHolder.getKey()).intValue();
	}
	
	public void update(Object object, String sql) {
		MapSqlParameterSource paramSource = createParameters(object);
		this.namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	private MapSqlParameterSource createParameters(Object object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				Field field = fields[i];
				if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
					field.setAccessible(true);
					paramSource.addValue(field.getName(), field.get(object));
					field.setAccessible(false);
				}
			} catch (Exception e) {
				throw new TechnicalException(ERROR_GETTING_THE_OBJECT_NAME_AND_VALUE, e);
			}
		}
		return paramSource;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return this.namedParameterJdbcTemplate;
	}
}
