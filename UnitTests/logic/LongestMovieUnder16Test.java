package logic;

import data.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestMovieUnder16Test {

    private LongestMovieUnder16 longestMovieUnder16UnderTest;

    @BeforeEach
    void setUp () {
        longestMovieUnder16UnderTest = new LongestMovieUnder16();
    }

    @Test
    void testGet () {
        // Setup

        // Run the test
        final Movie result = longestMovieUnder16UnderTest.get();

        // Verify the results
    }
}
