package com.example.app;

import com.example.core.ForexConverter;
import com.example.tax.TaxCalculator;

public class MainApp {
    public static void main(String[] args) {
        ForexConverter fx = new ForexConverter();
        TaxCalculator tx = new TaxCalculator();

        System.out.println("1000 INR in USD: " + fx.inrToUsd(1000));
        System.out.println("GST on 1000 INR: " + tx.calculateGST(1000));
    }
}
