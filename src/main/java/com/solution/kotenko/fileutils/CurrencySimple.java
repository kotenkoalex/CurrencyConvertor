/*
 * Classname - CurrencySimple
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.fileutils;

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

    @SuppressWarnings("unused")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    @SuppressWarnings("unused")
    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }
}