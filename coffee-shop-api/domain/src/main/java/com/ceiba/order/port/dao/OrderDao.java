package com.ceiba.order.port.dao;

import com.ceiba.order.model.dto.OrderDto;


public interface OrderDao {

    /**
     * Permite listar pedido
     *
     * @param orderId id del pedido
     * @return pedido
     */
    OrderDto getById(Integer orderId);


}
