package com.ceiba.order.model.dto;

import com.ceiba.order.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer orderGrossPrice;
    private Double discount;
    private Double charges;
    private Double total;
    private Date date;

    public static OrderDto fromEntity(Order order){
        return new OrderDto(
                order.getId(),
                (int)order.getOrderGrossPrice().getAmount(),
                order.getOrderDiscount().getAmount(),
                order.getCharges().getAmount(),
                order.getTotal().getAmount(),
                order.getDate());
    }

    public static OrderDto fromEntity(Order order, int orderId){
        return new OrderDto(
                orderId,
                (int)order.getOrderGrossPrice().getAmount(),
                order.getOrderDiscount().getAmount(),
                order.getCharges().getAmount(),
                order.getTotal().getAmount(),
                order.getDate());
    }
}
