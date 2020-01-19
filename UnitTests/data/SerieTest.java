package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerieTest {

    private Serie serieUnderTest;

    @BeforeEach
    void setUp () {
        serieUnderTest = new Serie("title", "genre", "language", 0, 0, 0, 0, "youMayLike");
    }

    @Test
    void testToString () {
        // Setup

        // Run the test
        final String result = serieUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
