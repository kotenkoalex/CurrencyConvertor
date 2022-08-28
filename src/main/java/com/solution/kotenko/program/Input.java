/*
 * Classname - ProgramLogic
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.program;

import com.solution.kotenko.currency.CurrencyOutput;
import com.solution.kotenko.fileutils.FileProcessor;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Input extends FileProcessor implements ProgramConstants {

    Logger LOGGER = Logger.getLogger(Input.class);

    {
        LOGGER.info("Created Input object");
    }

    public void start(ProgramLogic programLogic) {
        System.out.println("You can find out how much each currency has changed for the selected period \n");
        System.out.println("Available period - " + fileCounter(REPOSITORY_PATH) + " days:");
        System.out.println(assortmentFilesName(REPOSITORY_PATH) + "\n");
        System.out.println("Available currencies: ");
        CurrencyOutput.printAvailableCurrency(programLogic.getCurrenciesList());
        System.out.println();
        System.out.println();
        LOGGER.info("Lunched user interface (start method)");
    }

    public int inputPeriod() {
        System.out.println("Input in how many days you want to receive currency changes: ");
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Got data from console (inputPeriod method)");
        return scanner.nextInt();
    }

    public String inputCurrencyCode() {
        System.out.println("Select a currency code: ");
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Got data from console (inputCurrencyCode method)");
        return scanner.nextLine();
    }


}