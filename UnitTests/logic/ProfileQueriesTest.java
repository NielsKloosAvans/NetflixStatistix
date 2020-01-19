package logic;

import data.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProfileQueriesTest {

    private ProfileQueries profileQueriesUnderTest;

    @BeforeEach
    void setUp () {
        profileQueriesUnderTest = new ProfileQueries();
    }

    @Test
    void testCreateProfile () {
        // Setup
        final Profile profile = new Profile("profileName", 0, "email");

        // Run the test
        final boolean result = profileQueriesUnderTest.createProfile(profile);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testUpdateProfile () {
        // Setup
        final Profile profile = new Profile("profileName", 0, "email");

        // Run the test
        final boolean result = profileQueriesUnderTest.updateProfile(profile);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testRemoveProfile () {
        // Setup
        final Profile profile = new Profile("profileName", 0, "email");

        // Run the test
        final boolean result = profileQueriesUnderTest.removeProfile(profile);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testGetAll () {
        // Setup

        // Run the test
        final List<Profile> result = profileQueriesUnderTest.getAll();

        // Verify the results
    }
}
