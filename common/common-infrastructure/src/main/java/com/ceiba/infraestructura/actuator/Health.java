package com.ceiba.infraestructura.actuator;

import com.ceiba.infraestructura.exception.TechnicalException;
import com.ceiba.infraestructura.exception.BlockNoServiceException;

/**
 * Interface que tiene por objetivo ser implementada por todos los bloques 
 * que quieran utilizar HealthCheck
 * 
 * @author sergio.villamizar
 *
 */

public interface Health {
	/**
	 * Registra los bloques implementados
	 */
	public void registerBlock();
	
	/**
	 * Valida la salud del bloque
	 * @throws BlockNoServiceException
	 */
	public void check() throws TechnicalException;//a�adir

}
