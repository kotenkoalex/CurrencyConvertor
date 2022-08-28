/*
 * Classname - CurrencyConvertor
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.currency;

/**
 * Represents utils for currency converting
 */
public class CurrencyConvertor {

    /**
     * Convert UAH to Currency
     *
     * @param uahAmount takes amount in national currency UAH
     * @param currency  takes Currency (object)
     * @return result of evaluation
     */
    public static double convertor(double uahAmount, Currency currency) {
        double rate = Double.parseDouble(currency.getRate());
        return uahAmount / rate;
    }
}