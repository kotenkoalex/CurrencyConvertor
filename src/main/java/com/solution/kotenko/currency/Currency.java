/*
 * Classname - Currency
 * Version info - 1.0
 * Date - 20.08.22
 * Copyright notice - © 2022 Alex Kotenko
 */
package com.solution.kotenko.currency;

/**
 * Represents currency
 * <p>
 * r030 - currency code (internal bank code)
 * txt - currency name UKR Local
 * rate - currency rate
 * cc - currency abbreviation
 * exchangedate - currency exchange date UKR Local and Zone
 */
public class Currency {

    private String r030;
    private String txt;
    private String rate;
    private String cc;
    private String exchangedate;

    public Currency() {
    }

    public Currency(String rate, String cc) {
        this.rate = rate;
        this.cc = cc;
    }

    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return "Currency code: " + cc + " " + ", currency rate: " + rate;
    }
}