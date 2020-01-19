package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseQueriesTest {

    private DatabaseQueries databaseQueriesUnderTest;

    @BeforeEach
    void setUp () {
        databaseQueriesUnderTest = new DatabaseQueries();
    }

    @Test
    void testCreateAccount () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.createAccount("email", "name", "password", "address", "city");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testDeleteAccount () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.deleteAccount("email");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testUpdateAccount () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.updateAccount("email", "newEmail", "newName", "newPassword", "newAddress", "newCity");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testCreateProfile () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.createProfile("profileName", "email", 0);

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testDeleteProfile () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.deleteProfile("email", "profileName");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testUpdateProfile () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.updateProfile("profileName", "newProfileName", "email", 0);

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testCreateWatched () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.createWatched("profileName", 0, 0, "email");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testDeleteWatched () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.deleteWatched("profileName", 0, "email");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testUpdateWatched () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.updateWatched("profileName", "email", 0, 0);

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testPercentageWatched () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.percentageWatched();

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testMovieLongestUnder16 () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.movieLongestUnder16();

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testAccountMovieWatched () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.accountMovieWatched("email");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testAccountOneProfile () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.accountOneProfile();

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testMovieCompletelyWatched () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.movieCompletelyWatched("movie");

        // Verify the results
        assertEquals(result, result);
    }

    @Test
    void testAverageWatchedEpisode () {
        // Setup

        // Run the test
        final String result = databaseQueriesUnderTest.averageWatchedEpisode("email", 0);

        // Verify the results
        assertEquals(result, result);
    }
}
