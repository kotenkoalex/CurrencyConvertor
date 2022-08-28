/*
 * Classname - FileMaker
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.file;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class FileMaker {
    /**
     * Create new file
     *
     * @param path     takes path to repository
     * @param fileName takes file name
     * @return absolute path to new file or empty String if filed will not create
     */
    @SuppressWarnings("unused")
    public static String fileMaker(String path, String fileName) {
        File file = new File(path, fileName);
        boolean isFileCreated = false;
        try {
            isFileCreated = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isFileCreated ? file.getAbsolutePath() : "";
    }

    /**
     * Create new file named current date .txt
     *
     * @param path     takes path to repository
     * @return absolute path to new file or empty String if filed will not create
     */
    @SuppressWarnings("unused")
    public static String fileMaker(String path) {
        LocalDate date = LocalDate.now();

        String month = "";
        if (date.getMonthValue() < 10) {
            month = String.valueOf(0) + date.getMonthValue();
        }
        String currentDate = date.getDayOfMonth() + "." + month + "." + date.getYear();
        File file = new File(path, currentDate + ".txt");
        boolean isFileCreated = false;
        try {
            isFileCreated = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isFileCreated ? file.getAbsolutePath() : "";
    }
}
