package com.ceiba.order;

import com.ceiba.BaseTest;
import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.testdatabuilder.CoffeeTestDataBuilder;
import com.ceiba.domain.exception.NoDataException;
import com.ceiba.order.model.entity.Order;
import com.ceiba.order.testdatabuilder.OrderTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTest {
    @Test
    public void validateOrderNullCoffees() {
        // act - assert
        BaseTest.assertThrows(() -> new OrderTestDataBuilder().whitCoffees(new ArrayList<>()).build(),
                NoDataException.class, "Ningún café encontrado");
    }

    @Test
    public void validateOrderSpecialityDiscount() {
        // arrange
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            coffees.add(new CoffeeTestDataBuilder().whitId(i).whitCategory(2).build());
        }
        Order order = new OrderTestDataBuilder().whitCoffees(coffees).build();

        // act - assert
        Assert.assertEquals(2.5d, order.getOrderDiscount().getAmount(), 0d);
    }

    @Test
    public void validateOrderClassicDiscount() {
        // arrange
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            coffees.add(new CoffeeTestDataBuilder().whitId(i).build());
        }
        Order order = new OrderTestDataBuilder().whitCoffees(coffees).whitCurrency("COP").build();

        // act - assert
        Assert.assertEquals(6d, order.getOrderDiscount().getAmount(), 0d);
    }

    @Test
    public void validateOrderGrossPrice() {
        // arrange
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            coffees.add(new CoffeeTestDataBuilder().whitId(i).build());
        }
        Order order = new OrderTestDataBuilder().whitCoffees(coffees).whitCurrency("COP").build();

        // act - assert
        Assert.assertEquals(50d, order.getOrderGrossPrice().getAmount(), 0d);
    }

    @Test
    public void validateOrderCharges() throws ParseException {
        // arrange
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            coffees.add(new CoffeeTestDataBuilder().whitId(i).build());
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = format.parse("2021-05-15");
        Order order = new OrderTestDataBuilder().whitCoffees(coffees).whitDate(now).build();

        // act - assert
        Assert.assertEquals(5d, order.getCharges().getAmount(), 0d);
    }

    @Test
    public void validateOrderTotal() throws ParseException {
        // arrange
        List<Coffee> coffees = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            coffees.add(new CoffeeTestDataBuilder().whitId(i).whitCategory(2).build());
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = format.parse("2021-05-15");
        Order order = new OrderTestDataBuilder().whitCoffees(coffees).whitDate(now).build();

        // act - assert
        Assert.assertEquals(52.5, order.getTotal().getAmount(), 0d);
    }
}

