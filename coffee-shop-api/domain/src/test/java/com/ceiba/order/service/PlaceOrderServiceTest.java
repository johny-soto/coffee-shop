package com.ceiba.order.service;

import com.ceiba.BaseTest;
import com.ceiba.domain.exception.NoDataException;
import com.ceiba.order.port.repository.OrderRepository;
import org.junit.Test;
import org.mockito.Mockito;


public class PlaceOrderServiceTest {

    @Test
    public void validatePlaceOrder() {
        // arrange
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        Mockito.doNothing().when(orderRepository).place(Mockito.anyInt());
        Mockito.when(orderRepository.exist(Mockito.anyInt())).thenReturn(true);

        PlaceOrderService placeOrderService = new PlaceOrderService(orderRepository);

        placeOrderService.execute(1);
        // act - assert
        Mockito.verify(orderRepository, Mockito.times(1)).place(1);

    }

    @Test
    public void validateNotFoundOrder() {
        // arrange
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        Mockito.doNothing().when(orderRepository).place(Mockito.anyInt());
        Mockito.when(orderRepository.exist(Mockito.anyInt())).thenReturn(false);

        PlaceOrderService placeOrderService = new PlaceOrderService(orderRepository);

        // act - assert
        BaseTest.assertThrows(() -> placeOrderService.execute(1),
                NoDataException.class, "Pedido no encontrado");
        Mockito.verify(orderRepository, Mockito.times(0)).place(1);
    }

}
