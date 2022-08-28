/*
 * Classname - FileProcessor
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FileProcessor {

    /**
     * Makes List of Path from current repository (inner method)
     *
     * @param repositoryUrl takes repository URL
     * @return List of Path
     */
    private static List<Path> getListOfPath(String repositoryUrl) {
        Path path = Path.of(repositoryUrl);
        List<Path> list = null;
        try {
            list = Files.list(path).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Counts number of files in current repository (all types)
     *
     * @param repositoryUrl takes repository URL
     * @return number of files all types or -1 if there are no files
     */
    protected static int fileCounter(String repositoryUrl) {
        List<Path> list = getListOfPath(repositoryUrl);
        if (list != null) {
            return list.size();
        }
        return -1;
    }

    /**
     * Make ArrayList of file's url
     *
     * @param repositoryUrl takes repository URL
     * @return ArrayList of file's url
     */
    @SuppressWarnings("unused")
    private static ArrayList<String> fileUrlString(String repositoryUrl) {
        List<Path> list = getListOfPath(repositoryUrl);

        if (list.size() <= 0) {
            return null;
        }

        ArrayList<String> urlList = new ArrayList<>();
        for (Path path : list) {
            urlList.add(path.toString());
        }
        return urlList;
    }

    /**
     * Make ArrayList of file's names
     *
     * @param repositoryUrl takes repository URL
     * @return ArrayList of file's names
     */
    @SuppressWarnings("unused")
    protected static ArrayList<String> assortmentFilesName(String repositoryUrl) {
        ArrayList<String> assortmentFilesName = fileUrlString(repositoryUrl);
        for (int i = 0; i < Objects.requireNonNull(assortmentFilesName).size(); i++) {
            String currentFileName = assortmentFilesName.get(i).substring(
                    assortmentFilesName.get(i).lastIndexOf("\\") + 1, //file extension is after last sign '\'
                    assortmentFilesName.get(i).length() - 4); //delete file extension
            assortmentFilesName.set(i, currentFileName);
        }
        return assortmentFilesName;
    }

    /**
     * Read all files and saved data from it to TreeMap (inner method)
     *
     * @param fileUrlString takes repository URL
     * @return TreeMap with saved data
     */
    private static TreeMap<String, ArrayList<CurrencySimple>> filesReaderData(ArrayList<String> fileUrlString) {
        TreeMap<String, ArrayList<CurrencySimple>> filesData = new TreeMap<>();

        ArrayList<CurrencySimple> currencySimpleArrayList;
        for (String currentPath : fileUrlString) {
            currencySimpleArrayList = new ArrayList<>();
            String currentFileName = currentPath.substring(
                    currentPath.lastIndexOf("\\") + 1, //file extension is after last sign '\'
                    currentPath.length() - 4); //delete file extension
            try (BufferedReader fileReader = new BufferedReader(new FileReader(currentPath))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    String delimiter = ":";
                    String currencyCode = line.substring(0, line.indexOf(delimiter));
                    String currencyRate = line.substring(line.indexOf(delimiter) + 1);
                    currencySimpleArrayList.add(new CurrencySimple(currencyCode, currencyRate));
                }
                filesData.put(currentFileName, currencySimpleArrayList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filesData;
    }

    /**
     * Makes an arraylist with changes in the selected currency for the specified period
     * @param datePeriod amount of days from today's date to previous
     *                   example: if today's date 28.08.22, datePeriod: 3 means - [26.08.22, 27.08.22, 28.08.22]
     * @param currencyCode takes code of currency
     * @param repositoryUrl takes repository URL
     * @return ArrayList with changes
     */
    @SuppressWarnings("unused")
    public static ArrayList<String> changesInCurrency(int datePeriod, String currencyCode, String repositoryUrl) {
        int fileCounter = fileCounter(repositoryUrl);
        if (datePeriod > fileCounter) {
            return null;
        }
        ArrayList<String> assortmentFilesName = assortmentFilesName(repositoryUrl);
        TreeMap<String, ArrayList<CurrencySimple>> filesReaderData =
                filesReaderData(Objects.requireNonNull(fileUrlString(repositoryUrl)));

        int periodFrom = assortmentFilesName.size() - datePeriod;
        int periodTo = assortmentFilesName.size();
        String key;
        ArrayList<String> changes = new ArrayList<>();
        ArrayList<CurrencySimple> currencySimples;
        for (int i = periodFrom; i < periodTo; i++) {
            key = assortmentFilesName.get(i);
            currencySimples = filesReaderData.get(key);
            for (CurrencySimple element : currencySimples) {
                if (element.getCurrencyCode().equals(currencyCode)) {
                    changes.add(element.getCurrencyRate());
                }
            }
        }
        return changes;
    }
}