/*
 * Classname - Main
 * Version info - 1.0
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko;

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //connect to API bank.gov.ua
        CurrencyAPIConnection currencyAPIConnection = new CurrencyAPIConnection();
        HttpURLConnection httpURLConnection = currencyAPIConnection.getHttpRequest();

        //save data from API to String ArrayList
        ArrayList<String> data = currencyAPIConnection.readDataFromApiToArrayList(httpURLConnection);

        //convert data from ArrayList to Currency list using JSON parsing
        CurrencyJSONParser currencyJSONParser = new CurrencyJSONParser();
        ArrayList<Currency> currencies = currencyJSONParser.parse(data);

        //print result to file
        String path = "src/main/resources/output.txt";
        CurrencyOutput.printAllCurrenciesToFile(path, currencies, 100);
    }
}