package com.ceiba.coffee.model.valueobject;

public class Currency {
    private String isoCode;

    public Currency(String isoCode) {
        this.setIsoCode(isoCode);
    }

    public String getIsoCode() {
        return isoCode;
    }

    private void setIsoCode(String isoCode) {
        try {
            java.util.Currency.getInstance(isoCode);
        }catch (Exception e ){
            throw new IllegalArgumentException(e);
        }

        this.isoCode = isoCode;
    }
}
