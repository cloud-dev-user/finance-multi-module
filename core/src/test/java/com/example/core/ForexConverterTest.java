package com.example.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForexConverterTest {

    @Test
    public void testConvertUsdToInr() {
        ForexConverter converter = new ForexConverter();
        double result = converter.convertUsdToInr(10, 80);
        assertEquals(800, result, 0.001);
    }
}
