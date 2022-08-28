/*
 * Classname - ProgramConstants
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.program;

import com.solution.kotenko.fileutils.FileProcessor;
import org.apache.log4j.Logger;

public class Output implements ProgramConstants {

    Logger LOGGER = Logger.getLogger(Output.class);

    {
        LOGGER.info("Created Output object");
    }

    public void showResult(int period, String currencyCode) {
        System.out.println(FileProcessor.changesInCurrency(period, currencyCode, REPOSITORY_PATH));
        LOGGER.info("Printed result in console (showResult method)");
        LOGGER.info("_____________________________________________");
    }
}