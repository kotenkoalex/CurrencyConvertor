/*
 * Classname - CurrencySimple
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.file;

/**
 * Represents utils for showing result
 */
public class CurrencySimple {

    private String currencyCode;
    private String currencyRate;


    public CurrencySimple(String currencyCode, String currencyRate) {
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }
}