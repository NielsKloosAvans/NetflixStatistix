package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    private Movie movieUnderTest;

    @BeforeEach
    void setUp () {
        movieUnderTest = new Movie("title", "genre", "language", 0, 0, 0);
    }

    @Test
    void testToString () {
        // Setup

        // Run the test
        final String result = movieUnderTest.toString();

        // Verify the results
        assertEquals("Movie: title\nDuration: 0", result);
    }
}
