package com.ceiba.infraestructura.controller;

import java.util.List;

import com.ceiba.infraestructura.actuator.BlocksHealthCheckHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.infraestructura.error.ErrorHealthCheck;

@RestController
@RequestMapping("/healthCheck")
public class HealthCheckController {
	
	private final BlocksHealthCheckHandler blocksHealthCheckHandler;
		
	public HealthCheckController(BlocksHealthCheckHandler blocksHealthCheckHandler) {
		this.blocksHealthCheckHandler = blocksHealthCheckHandler;
	}
	
	@GetMapping
	public ResponseEntity<Object>  healthCheck() {
		if (this.blocksHealthCheckHandler.errorsExist()) {
			List<ErrorHealthCheck> listErrorsBlocks = this.blocksHealthCheckHandler.getListErrorsBlocks();//a�adir
			return new ResponseEntity<Object>(listErrorsBlocks, HttpStatus.SERVICE_UNAVAILABLE);
		} else {
			return new ResponseEntity<Object>(true,HttpStatus.OK );
		}
	}
}
