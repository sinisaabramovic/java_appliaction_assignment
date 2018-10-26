package com.example.java;

import Currency.CurrencyController;
import Report.Report;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        // CurrencyController collectes data from web source
        CurrencyController currencyController = CurrencyController.getInstance();
        currencyController.importCurrencies("http://api.hnb.hr/tecajn/v1?datum=2018-10-24");
        currencyController.printCurrencies();

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Part 3 of the assignment
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Singleton Report generates output report to html file
        Report report = Report.getInstance();
        report.writeToHtml(currencyController.getCurrencies(),"data/result.html");


    }
}
