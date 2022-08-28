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
import com.solution.kotenko.fileutils.FileMaker;
import org.apache.log4j.Logger;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.ArrayList;


public class ProgramLogic implements ProgramConstants {

    Logger LOGGER = Logger.getLogger(ProgramLogic.class);

    {
        LOGGER.info("_____________________________________________");
        LOGGER.info(LocalDate.now());
        LOGGER.info("Created ProgramLogic object");
    }

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
        LOGGER.info("Created currencies list from API");
    }

    /**
     * Create file with currencies rates on current date
     */
    public void createFileOnCurrentDate() {
        this.pathTodayFile = FileMaker.fileMaker(REPOSITORY_PATH);
        LOGGER.info("Created file on current date");
    }

    public ArrayList<Currency> getCurrenciesList() {
        return currenciesList;
    }

    public String getPathTodayFile() {
        return pathTodayFile;
    }
}