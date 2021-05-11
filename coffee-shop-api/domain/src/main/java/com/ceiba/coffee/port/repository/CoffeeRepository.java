package com.ceiba.coffee.port.repository;

import com.ceiba.coffee.model.entity.Coffee;

public interface CoffeeRepository {
    /**
     * Permite crear un cafe
     * @param coffee
     * @return el id generado
     */
    Integer create(Coffee coffee);

    /**
     * Permite actualizar un cafe
     * @param coffee
     */
    void update(Coffee coffee);

    /**
     * Permite eliminar un cafe
     * @param id
     */
    void delete(int id);

    /**
     * Permite validar si existe un cafe con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean exist(int nombre);


}
