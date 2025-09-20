import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ForexConverterTest {
    @Test
    void testConversion() {
        ForexConverter converter = new ForexConverter();
        double result = converter.convert(100, 1.1);
        assertEquals(110.0, result, 0.001);
    }
}

