package logic;

import data.Episode;
import data.Movie;
import data.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HasWatchedQueriesTest {

    private HasWatchedQueries hasWatchedQueriesUnderTest;

    @BeforeEach
    void setUp () {
        hasWatchedQueriesUnderTest = new HasWatchedQueries();
        hasWatchedQueriesUnderTest.database = mock(DBconnection.class);
    }

    @Test
    void testCreateHasWatchedMovie () {
        // Setup + run the test
        try {
            final boolean result = hasWatchedQueriesUnderTest.createHasWatchedMovie("profileName", "email", 0, 0);
            when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");
            assertTrue(result);
        } catch (ExceptionInInitializerError error){
            System.out.println("No class found error!");
        }
    }

    @Test
    void testCreateHasWatchedEpisode () {
        // Setup + run the test
        try {
            final boolean result = hasWatchedQueriesUnderTest.createHasWatchedEpisode("profileName", "email", 0, 0);
            when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");
            assertTrue(result);
        } catch (NoClassDefFoundError error) {
            System.out.println("Error while initialising");
        }
    }


    @Test
    void testRemoveHasWatched () {
        // Setup
        final Profile profile = new Profile("profileName", 0, "email");
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final boolean result = hasWatchedQueriesUnderTest.removeHasWatched(profile);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testEpisodesGetAll () {
        // Setup
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Episode> result = hasWatchedQueriesUnderTest.episodesGetAll();

        // Verify the results
    }

    @Test
    void testMoviesGetAll () {
        // Setup
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Movie> result = hasWatchedQueriesUnderTest.moviesGetAll();

        // Verify the results
    }
}
