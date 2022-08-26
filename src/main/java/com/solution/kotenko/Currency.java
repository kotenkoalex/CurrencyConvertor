/*
 * Classname - Currency
 * Version info - 1.0
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko;

/**
 * Represents currency
 */
public class Currency {

    //currency code (internal bank code)
    private String r030;

    //currency name UKR Local
    private String txt;

    //currency rate
    private String rate;

    //currency abbreviation
    private String cc;

    //currency exchange date UKR Local and Zone
    private String exchangedate;

    public Currency() {
    }

    public Currency(String rate, String cc) {
        this.rate = rate;
        this.cc = cc;
    }

    /**
     * Represents useful information
     *
     * @return Currency code + currency rate
     */
    @Override
    public String toString() {
        return "Currency code: " + cc + " " + ", currency rate: " + rate;
    }

    /**
     * Getter
     *
     * @return r030
     */
    public String getR030() {
        return r030;
    }

    /**
     * Setter
     *
     * @param r030 takes value
     */
    public void setR030(String r030) {
        this.r030 = r030;
    }

    /**
     * Getter
     *
     * @return txt
     */
    public String getTxt() {
        return txt;
    }

    /**
     * Setter
     *
     * @param txt takes value
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }

    /**
     * Getter
     *
     * @return rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * Setter
     *
     * @param rate takes value
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Getter
     *
     * @return cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * Setter
     *
     * @param cc takes value
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Getter
     *
     * @return exchangedate
     */
    public String getExchangedate() {
        return exchangedate;
    }

    /**
     * Setter
     *
     * @param exchangedate takes value
     */
    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }
}