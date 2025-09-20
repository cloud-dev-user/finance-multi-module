package com.example.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForexConverterTest {

    private final ForexConverter converter = new ForexConverter();

    @Test
    void testInrToUsd() {
        // 100 INR should convert to 1.2 USD (100 * 0.012)
        double result = converter.inrToUsd(100);
        assertEquals(1.2, result, 0.0001, "100 INR should equal 1.2 USD");
    }

    @Test
    void testUsdToInr() {
        // 1 USD should convert to 83.33 INR (1 / 0.012)
        double result = converter.usdToInr(1);
        assertEquals(83.3333, result, 0.0001, "1 USD should equal ~83.33 INR");
    }

    @Test
    void testRoundTripConversion() {
        // Convert INR → USD → INR (round-trip should be close to original)
        double inr = 500;
        double usd = converter.inrToUsd(inr);
        double inrBack = converter.usdToInr(usd);

        assertEquals(inr, inrBack, 0.0001, "Round-trip INR→USD→INR should return original value");
    }

    @Test
    void testZeroValues() {
        assertEquals(0.0, converter.inrToUsd(0), "0 INR should equal 0 USD");
        assertEquals(0.0, converter.usdToInr(0), "0 USD should equal 0 INR");
    }

    @Test
    void testNegativeValues() {
        // Negative input should produce negative output
        assertEquals(-1.2, converter.inrToUsd(-100), 0.0001, "Negative INR should result in negative USD");
        assertEquals(-83.3333, converter.usdToInr(-1), 0.0001, "Negative USD should result in negative INR");
    }
}
