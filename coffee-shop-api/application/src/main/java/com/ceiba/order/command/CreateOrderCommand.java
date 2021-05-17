package com.ceiba.order.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderCommand {
    private List<Integer> coffees;
    private String currency;

    public CreateOrderCommand(List<Integer> coffees, String currency) {
        setCoffees(coffees);
        this.currency = currency;
    }

    public void setCoffees(List<Integer> coffees) {
        this.coffees = coffees;
        if (coffees.isEmpty()) {
            this.coffees = null;
        }
    }
}
