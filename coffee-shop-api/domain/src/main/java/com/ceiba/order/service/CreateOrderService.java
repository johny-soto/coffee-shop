package com.ceiba.order.service;


import com.ceiba.order.model.entity.Order;
import com.ceiba.order.port.repository.OrderRepository;


public class CreateOrderService {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Integer execute(Order order) {
        return this.orderRepository.create(order);
    }

}
