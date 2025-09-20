package com.example.tax;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {
    @Test
    void testGST() {
        TaxCalculator t = new TaxCalculator();
        assertEquals(18, t.calculateGST(100), 0.1);
    }
}
