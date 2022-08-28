package com.solution.kotenko;

import com.solution.kotenko.currency.Currency;
import com.solution.kotenko.currency.CurrencyConvertor;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyConvertorTest {

    @Test
    public void convertorUAHtoUSD() {
        Currency currency = new Currency("36.63", "USD");
        double actualResult = CurrencyConvertor.convertor(109.89, currency);
        double expectedResult = 3;
        assertEquals(expectedResult, actualResult, 0.00);
    }

    @Test
    public void convertorUAHtoCAD() {
        Currency currency = new Currency("28.32", "CAD");
        double actualResult = CurrencyConvertor.convertor(84.98, currency);
        double expectedResult = 3.0007062146892656;
        assertEquals(expectedResult, actualResult, 0.00);
    }

    @Test
    public void convertorUAHtoUAH() {
        Currency currency = new Currency("1", "UAH");
        double actualResult = CurrencyConvertor.convertor(3, currency);
        double expectedResult = 3;
        assertEquals(expectedResult, actualResult, 0.00);
    }
}