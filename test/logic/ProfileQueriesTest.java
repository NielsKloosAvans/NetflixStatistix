package logic;

import data.Account;
import data.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProfileQueriesTest {

    private ProfileQueries profileQueriesUnderTest;

    @BeforeEach
    void setUp() {
        profileQueriesUnderTest = new ProfileQueries();
    }


    @Test
    void testGetAll() {
        // Setup

        // Run the test
        final List<Profile> result = profileQueriesUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetProfilesFromAccount() {
        // Setup
        final Account account = new Account("email", "name", "password", "address", "city");

        // Run the test
        final List<Profile> result = profileQueriesUnderTest.getProfilesFromAccount(account);

        // Verify the results
    }
}
