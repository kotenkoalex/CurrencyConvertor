/*
 * Classname - CurrencyOutput
 * Version info - 1.0
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko;

import java.io.FileWriter;
import java.io.IOException;
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
}