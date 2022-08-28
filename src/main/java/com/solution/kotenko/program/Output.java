/*
 * Classname - ProgramConstants
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.program;

import com.solution.kotenko.file.FileProcessor;

public class Output implements ProgramConstants {

    public void showResult(int period, String currencyCode) {
        System.out.println(FileProcessor.changesInCurrency(period, currencyCode, REPOSITORY_PATH));
    }
}