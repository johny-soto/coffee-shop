package com.ceiba.infraestructura.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ceiba.infraestructura.filter.FilterHeaderSecurity;

@Configuration
public class HeaderSetting {
	
	@Bean
	public FilterHeaderSecurity headerFilter() {
		return new FilterHeaderSecurity();
	}

}