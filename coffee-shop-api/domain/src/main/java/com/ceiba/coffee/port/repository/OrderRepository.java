package com.ceiba.coffee.port.repository;

import com.ceiba.coffee.model.entity.Order;

public interface OrderRepository {
    /**
     * Permite crear un pedido
     * @param order pedido
     * @return el id generado
     */
    Integer create(Order order);

    /**
     * Permite realizar un pedido
     * @param orderId identificador del pedido
     */
    void place(Integer orderId);

    /**
     * Permite validar si existe un pedidp con id
     * @param id id del pedido
     * @return boolean si existe o no
     */
    boolean exist(int id);
}
