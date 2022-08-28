/*
 * Classname - ProgramLogic
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.program;

import com.solution.kotenko.currency.Currency;
import com.solution.kotenko.currency.CurrencyAPIConnection;
import com.solution.kotenko.currency.CurrencyJSONParser;
import com.solution.kotenko.file.FileMaker;

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class ProgramLogic implements ProgramConstants {

    private ArrayList<Currency> currenciesList;
    private String pathTodayFile;

    /**
     * Create file with currencies rates on current date
     */
    public void createCurrenciesListFromAPI() {
        CurrencyAPIConnection currencyAPIConnection = new CurrencyAPIConnection();
        HttpURLConnection httpURLConnection = currencyAPIConnection.getHttpRequest();
        ArrayList<String> data = currencyAPIConnection.readDataFromApiToArrayList(httpURLConnection);
        CurrencyJSONParser currencyJSONParser = new CurrencyJSONParser();
        this.currenciesList = currencyJSONParser.parse(data);
    }

    /**
     * Create file with currencies rates on current date
     */
    public void createFileOnCurrentDate() {
        this.pathTodayFile = FileMaker.fileMaker(REPOSITORY_PATH);
    }

    public ArrayList<Currency> getCurrenciesList() {
        return currenciesList;
    }

    public String getPathTodayFile() {
        return pathTodayFile;
    }
}