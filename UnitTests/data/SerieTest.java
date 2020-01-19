package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerieTest {

    private Series serieUnderTest;

    @BeforeEach
    void setUp () {
        serieUnderTest = new Series("title", "genre", "language", 0, 0, 0, 0, "youMayLike");
    }

    @Test
    void testToString () {
        // Setup

        // Run the test
        final String result = serieUnderTest.toString();

        // Verify the results
        assertEquals("Series title: title", result);
    }
}
