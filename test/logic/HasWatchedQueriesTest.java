package logic;

import data.Episode;
import data.Movie;
import data.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HasWatchedQueriesTest {

    private HasWatchedQueries hasWatchedQueriesUnderTest;

    @BeforeEach
    void setUp() {
        hasWatchedQueriesUnderTest = new HasWatchedQueries();
        hasWatchedQueriesUnderTest.database = mock(DBconnection.class);
    }


    @Test
    void testEpisodesGetAll() {
        // Setup
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Episode> result = hasWatchedQueriesUnderTest.episodesGetAll();

        // Verify the results
    }

    @Test
    void testMoviesGetAll() {
        // Setup
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Movie> result = hasWatchedQueriesUnderTest.moviesGetAll();

        // Verify the results
    }
}
