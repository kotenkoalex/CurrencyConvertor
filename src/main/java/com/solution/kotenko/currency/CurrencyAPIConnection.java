/*
 * Classname - CurrencyAPIConnection
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.currency;

import com.solution.kotenko.program.ProgramConstants;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Represents utils to work with bank API
 */
public class CurrencyAPIConnection implements ProgramConstants {

    private final Logger LOGGER = Logger.getLogger(CurrencyAPIConnection.class);

    /**
     * Checks API and creates http connection
     *
     * @return http URL connection
     */
    public HttpURLConnection getHttpRequest() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return httpURLConnection;
            }
        } catch (MalformedURLException e) {
            LOGGER.info(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Converts data from API to ArrayList<String>
     *
     * @param httpURLConnection takes connection
     * @return data
     */
    public ArrayList<String> readDataFromApiToArrayList(HttpURLConnection httpURLConnection) {

        if (httpURLConnection == null) {
            return null;
        }

        //read data from API to ArrayList
        ArrayList<String> data = new ArrayList<>();
        StringBuilder result = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            String inputLine;
            result = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //delete square brackets []
        assert result != null;
        result = new StringBuilder(result.toString().replace("[", ""));
        result = new StringBuilder(result.toString().replace("]", ""));

        StringTokenizer st = new StringTokenizer(result.toString(), "}");
        while (st.hasMoreTokens()) {
            data.add(st.nextToken());
        }

        //return the curly braces to their place (needs for getting correct JSON format)
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).replace(",{", "{"));
            data.set(i, data.get(i) + "}");
        }

        return data;
    }

}