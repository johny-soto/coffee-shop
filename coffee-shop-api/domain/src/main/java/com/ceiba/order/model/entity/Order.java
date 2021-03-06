package com.ceiba.order.model.entity;

import com.ceiba.coffee.model.entity.Coffee;
import com.ceiba.coffee.model.entity.CoffeeCategory;
import com.ceiba.coffee.model.valueobject.Currency;
import com.ceiba.coffee.model.valueobject.Money;
import com.ceiba.domain.exception.NoDataException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.ceiba.coffee.model.valueobject.Currency.USD;

public class Order {
    private int id;
    private List<Coffee> coffees;
    private Currency currency;
    private Money orderGrossPrice;
    private Money orderDiscount;
    private Money charges;
    private Money total;
    private Date date;

    public Order(List<Coffee> coffees, Currency currency, Date date) {
        if (coffees.isEmpty()) {
            throw new NoDataException("Ningún café encontrado");
        }
        this.coffees = coffees;
        this.currency = currency;
        this.date = date;
        this.orderGrossPrice = calculateOrderGrossPrice();
        this.orderDiscount = calculateDiscounts();
        this.charges = calculateAdditionalCharges();
        this.total = calculateTotal();
    }

    private Money calculateDiscounts() {
        if (currency.equals(USD)) {
            return getSpecialityCoffeeDiscount();
        }else {
            return getDiscountForAll();
        }
    }

    private Money calculateOrderGrossPrice(){
        var value = new Money(0, USD);
        for (Coffee coffees : this.coffees) {
            value = value.add(coffees.getPrice().getAmount());
        }
        return value;
    }

    private Money getSpecialityCoffeeDiscount() {
        Money discount = new Money(0, USD);
        List<Coffee> specialityCoffees = coffees.stream()
                .filter(coffee -> coffee.getCategory().getId() == CoffeeCategory.speciality.getId())
                .collect(Collectors.toList());
        if (!specialityCoffees.isEmpty()) {
            for (Coffee coffee : specialityCoffees) {
                discount = discount.add(coffee.getPrice().getAmount() * 5 / 100);
            }
        }
        return discount;
    }

    private Money getDiscountForAll(){
        var discount = new Money(0, USD);
        List<Coffee> classicCoffees = coffees.stream()
                .filter(coffee -> coffee.getCategory().getId() == CoffeeCategory.classic.getId())
                .collect(Collectors.toList());
        if (classicCoffees.size() > 5) {
            return discount.add(this.orderGrossPrice.getAmount() * 10 / 100);
        }
        return discount;
    }

    private Money calculateAdditionalCharges(){
        var additionalCharges = new Money(0, USD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            additionalCharges = additionalCharges.add(orderGrossPrice.getAmount() * 10 / 100);
        }
        return additionalCharges;
    }

    private Money calculateTotal() {
        Money total = orderGrossPrice;
        total = total.add(charges.getAmount());
        total = total.subtract(orderDiscount.getAmount());
        return total;
    }

    public int getId() {
        return id;
    }


    public Currency getCurrency() {
        return currency;
    }

    public Money getOrderGrossPrice() {
        return orderGrossPrice;
    }

    public Money getOrderDiscount() {
        return orderDiscount;
    }

    public Money getCharges() {
        return charges;
    }

    public Money getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }
}
