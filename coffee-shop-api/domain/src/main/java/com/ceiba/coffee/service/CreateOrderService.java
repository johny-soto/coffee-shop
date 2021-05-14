package com.ceiba.coffee.service;


import com.ceiba.coffee.model.entity.Order;
import com.ceiba.coffee.port.repository.OrderRepository;


public class CreateOrderService {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Integer execute(Order order) {
        return this.orderRepository.create(order);
    }

}
