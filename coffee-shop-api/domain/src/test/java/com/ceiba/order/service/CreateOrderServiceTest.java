package com.ceiba.order.service;

import com.ceiba.order.model.entity.Order;
import com.ceiba.order.port.repository.OrderRepository;
import com.ceiba.order.testdatabuilder.OrderTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CreateOrderServiceTest {

    @Test
    public void validateCreateCoffee() {
        // arrange
        Order order = new OrderTestDataBuilder().build();
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        Mockito.when(orderRepository.create(Mockito.anyObject())).thenReturn(1);
        CreateOrderService createOrderService = new CreateOrderService(orderRepository);
        // act - assert
        assertEquals(1, (int) createOrderService.execute(order));
    }

}
