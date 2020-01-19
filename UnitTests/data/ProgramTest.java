package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramTest {

    private Program programUnderTest;

    @BeforeEach
    void setUp () {
        programUnderTest = new Program("title", "genre", "language",  0) {
        };
    }

    @Test
    void testToString () {
        // Setup

        // Run the test
        final String result = programUnderTest.toString();

        // Verify the results
        assertEquals("Program title: title" , result);
    }
}
