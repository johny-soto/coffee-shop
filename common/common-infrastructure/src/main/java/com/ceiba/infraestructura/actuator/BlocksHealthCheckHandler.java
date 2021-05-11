package com.ceiba.infraestructura.actuator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import com.ceiba.infraestructura.error.ErrorHealthCheck;

@Configuration
public class BlocksHealthCheckHandler {

	private Map<String, Health> registeredBlocks = new HashMap<>();
	private List<ErrorHealthCheck> listErrorsBlocks = new ArrayList<>();
	private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(BlocksHealthCheckHandler.class);
	private static final String BLOCK_ERROR_MESSAGE = "Error de conexion con el bloque ";

	public void signUp(String blockName, Health health) {
		this.registeredBlocks.put(blockName, health);
	}

	@Scheduled(fixedRateString = "${tiempoHealthCheck.tiempo}")
	public void refreshListErrors() {
		this.registeredBlocks.forEach((key, value) -> validateBlock(key, this.registeredBlocks.get(key)));

	}

	private void validateBlock(String key, Health health) {
		try {
			health.check();
			this.listErrorsBlocks = new ArrayList<>();
		} catch (RuntimeException e) {
			LOGGER_ERROR.error(BLOCK_ERROR_MESSAGE + key);
			this.listErrorsBlocks = new ArrayList<>();
			this.listErrorsBlocks.add(new ErrorHealthCheck(key));
		}
	}

	public boolean errorsExist() {
		return !listErrorsBlocks.isEmpty();
	}

	public List<ErrorHealthCheck> getListErrorsBlocks() {
		return listErrorsBlocks;
	}

}
