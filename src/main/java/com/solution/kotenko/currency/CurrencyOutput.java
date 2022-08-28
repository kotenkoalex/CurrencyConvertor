/*
 * Classname - CurrencyOutput
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.currency;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Represents utils for showing result
 */
public class CurrencyOutput extends CurrencyConvertor {

    /**
     * Print converted values from UAH to Currencies
     *
     * @param path       takes path to output file
     * @param currencies takes currencies data
     * @param uahAmount  takes amount of UAH
     */
    @SuppressWarnings("unused")
    public static void printAllCurrenciesToFile(String path, ArrayList<Currency> currencies, double uahAmount) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            for (Currency element : currencies) {
                fileWriter.write(
                        uahAmount + " UAH to " +
                                element.getCc() + " = " +
                                CurrencyConvertor.convertor(uahAmount, element) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print currency rates Currency/UAH
     *
     * @param path       takes path to output file
     * @param currencies takes currencies data
     */
    public static void printAllCurrencyRates(String path, ArrayList<Currency> currencies) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            for (Currency element : currencies) {
                double rate = Double.parseDouble(element.getRate());
                String formattedRate = new DecimalFormat("#0.000000").format(rate);
                fileWriter.write(element.getCc() + ":" + formattedRate + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print all possible currency codes
     *
     * @param currencies takes currencies data
     */
    public static void printAvailableCurrency(ArrayList<Currency> currencies) {
        int counter = 0;
        int nextLine = 20; //print 20 items in 1 line
        for (Currency currency : currencies) {
            counter++;
            if (counter > nextLine) {
                System.out.println();
                counter = 0;
            }
            System.out.print(currency.getCc() + ", ");
        }
    }


}