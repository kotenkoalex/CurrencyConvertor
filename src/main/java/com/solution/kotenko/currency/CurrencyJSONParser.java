/*
 * Classname - CurrencyJSONParser
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.currency;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Represents utils for parsing JSON
 */
public class CurrencyJSONParser {

    /**
     * Convert JSON in String format to Currency
     *
     * @param data takes ArrayList with currencies JSON in String format
     * @return ArrayList<Currency>
     */
    public ArrayList<Currency> parse(ArrayList<String> data) {
        ArrayList<Currency> currencies = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            for (String element : data) {
                JSONObject object = (JSONObject) parser.parse(element);
                Currency currency = new Currency();
                currency.setCc(String.valueOf(object.get("cc")));
                currency.setExchangedate(String.valueOf(object.get("exchangedate")));
                currency.setR030(String.valueOf(object.get("r030")));
                currency.setRate(String.valueOf(object.get("rate")));
                currency.setTxt(String.valueOf(object.get("txt")));
                currencies.add(currency);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}