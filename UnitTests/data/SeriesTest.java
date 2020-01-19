package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeriesTest {

    private Series seriesUnderTest;

    @BeforeEach
    void setUp() {
        seriesUnderTest = new Series(0, "title", "genre", "language", 0, 0, "youMayLike");
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = seriesUnderTest.toString();

        // Verify the results
        assertEquals("Series title: title", result);
    }

    @Test
    void testGetTitle() {
        // Setup

        // Run the test
        final String result = seriesUnderTest.getTitle();

        // Verify the results
        assertEquals("title", result);
    }
}
