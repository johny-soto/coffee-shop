package com.ceiba.infraestructura.setting;

import javax.sql.DataSource;

import com.ceiba.infraestructura.actuator.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthSetting {
	
	
	private final  DataSource dataSource;
	
	
	public HealthSetting(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Bean
    public DataSourceHealthIndicator dataSourceHealthIndicator() {
		return new DataSourceHealthIndicator(this.dataSource);
       
    } 

}
