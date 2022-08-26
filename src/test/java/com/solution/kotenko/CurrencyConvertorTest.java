package com.solution.kotenko;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyConvertorTest {

    @Test
    public void convertorUAHtoUSD() {
        Currency currency = new Currency("36.63", "USD");
        assertEquals((int)CurrencyConvertor.convertor(109.89, currency), 3);
    }

    @Test
    public void convertorUAHtoCAD() {
        Currency currency = new Currency("28.32", "CAD");
        assertEquals((int)CurrencyConvertor.convertor(84.98, currency), 3);
    }

    @Test
    public void convertorUAHtoUAH() {
        Currency currency = new Currency("1", "UAH");
        assertEquals((int)CurrencyConvertor.convertor(3, currency), 3);
    }
}