package logic;

import data.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testCreateHasWatched () {
        // Setup
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final boolean result = hasWatchedQueriesUnderTest.createHasWatched("profileName", "email", 0, 0);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testUpdateHasWatched () {
        // Setup
        when(hasWatchedQueriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final boolean result = hasWatchedQueriesUnderTest.updateHasWatched("profileName", "email", 0, 0);

        // Verify the results
        assertFalse(result);
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
}
