package UI.Controllers;

import data.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ProfileSettingsControllerTest {

    private ProfileSettingsController profileSettingsControllerUnderTest;

    @BeforeEach
    void setUp () {
        profileSettingsControllerUnderTest = new ProfileSettingsController();
        profileSettingsControllerUnderTest.accounts = Arrays.asList(new Account("email", "name", "password", "address", "city"));
    }

    @Test
    void testPrintProfiles () {
        // Setup

        // Run the test
        profileSettingsControllerUnderTest.printProfiles();

        // Verify the results
    }

    @Test
    void testRefreshAccount () {
        // Setup

        // Run the test
        profileSettingsControllerUnderTest.refreshAccount();

        // Verify the results
    }

    @Test
    void testRefreshAccountsUpdate () {
        // Setup

        // Run the test
        profileSettingsControllerUnderTest.refreshAccountsUpdate();

        // Verify the results
    }
}
