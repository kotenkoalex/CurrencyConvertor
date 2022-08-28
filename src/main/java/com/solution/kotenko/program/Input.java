/*
 * Classname - ProgramLogic
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.program;

import com.solution.kotenko.currency.CurrencyOutput;
import com.solution.kotenko.file.FileProcessor;

import java.util.Scanner;

public class Input extends FileProcessor implements ProgramConstants {

    public void start(ProgramLogic programLogic) {
        System.out.println("You can find out how much each currency has changed for the selected period \n");
        System.out.println("Available period - " + fileCounter(REPOSITORY_PATH) + " days:");
        System.out.println(assortmentFilesName(REPOSITORY_PATH) + "\n");
        System.out.println("Available currencies: ");
        CurrencyOutput.printAvailableCurrency(programLogic.getCurrenciesList());
        System.out.println();
        System.out.println();
    }

    public int inputPeriod() {
        System.out.println("Input in how many days you want to receive currency changes: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputCurrencyCode() {
        System.out.println("Select a currency code: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}