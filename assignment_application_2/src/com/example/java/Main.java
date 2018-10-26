package com.example.java;

import Currency.CurrencyController;

public class Main {

    public static void main(String[] args) {

        CurrencyController currencyController = CurrencyController.getInstance();

        currencyController.importCurrencies("http://api.hnb.hr/tecajn/v1?datum=2018-10-24");

        currencyController.printCurrencies();

    }
}
