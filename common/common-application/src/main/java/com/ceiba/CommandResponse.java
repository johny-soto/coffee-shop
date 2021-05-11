package com.ceiba;

public class CommandResponse<T> {

    private T value;

    public CommandResponse(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
