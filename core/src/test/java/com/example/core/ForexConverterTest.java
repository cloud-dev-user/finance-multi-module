package com.example.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ForexConverterTest {
    @Test
    void testInrToUsd() {
        ForexConverter fx = new ForexConverter();
        assertEquals(12, fx.inrToUsd(1000), 0.5);
    }
}
