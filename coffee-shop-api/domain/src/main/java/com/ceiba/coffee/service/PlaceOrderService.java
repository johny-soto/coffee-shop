package com.ceiba.coffee.service;

import com.ceiba.coffee.port.repository.OrderRepository;
import com.ceiba.domain.exception.NoDataException;

public class PlaceOrderService {

    private static final String ORDER_NOT_FOUND = "Pedido no encontrado";
    private final OrderRepository orderRepository;

    public PlaceOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void execute(Integer orderId){
        validateExistence(orderId);
        orderRepository.place(orderId);
    }

    private void validateExistence(Integer orderId) {
        boolean exist = this.orderRepository.exist(orderId);
        if(!exist) {
            throw new NoDataException(ORDER_NOT_FOUND);
        }
    }
}
