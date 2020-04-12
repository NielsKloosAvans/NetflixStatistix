package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieCompletelyWatchedTest {

    private MovieCompletelyWatched movieCompletelyWatchedUnderTest;

    @BeforeEach
    void setUp() {
        movieCompletelyWatchedUnderTest = new MovieCompletelyWatched();
    }

    @Test
    void testMovie() {
        // Setup

        // Run the test
        final int result = movieCompletelyWatchedUnderTest.Movie(0);

        // Verify the results
        assertEquals(0, result);
    }
}
