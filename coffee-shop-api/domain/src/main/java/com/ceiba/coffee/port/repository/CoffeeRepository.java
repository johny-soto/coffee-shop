package com.ceiba.coffee.port.repository;

import com.ceiba.coffee.model.entity.Coffee;

public interface CoffeeRepository {
    /**
     * Permite crear un cafe
     * @param coffee entidad
     * @return el id generado
     */
    Integer create(Coffee coffee);

    /**
     * Permite actualizar un cafe
     * @param coffee entidad
     */
    void update(Coffee coffee);

    /**
     * Permite eliminar un cafe
     * @param id id del café
     */
    void delete(int id);

    /**
     * Permite validar si existe un cafe con un nombre
     * @param id id del café
     * @return si existe o no
     */
    boolean exist(int id);


}
