/*
 * Classname - Main
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko;

import com.solution.kotenko.currency.CurrencyOutput;
import com.solution.kotenko.program.Input;
import com.solution.kotenko.program.Output;
import com.solution.kotenko.program.ProgramLogic;

/**
 * Class provides major logic
 */
public class Main {

    public static void main(String[] args) {
        ProgramLogic programLogic = new ProgramLogic();
        programLogic.createCurrenciesListFromAPI();
        programLogic.createFileOnCurrentDate();

        CurrencyOutput.printAllCurrencyRates(
                programLogic.getPathTodayFile(), programLogic.getCurrenciesList());
        Input input = new Input();
        input.start(programLogic);
        int period = input.inputPeriod();
        String currencyCode = input.inputCurrencyCode();

        Output output = new Output();
        output.showResult(period, currencyCode);
    }
}