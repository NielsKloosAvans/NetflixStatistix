
package UI.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountSettingsControllerTest {

    private AccountSettingsController accountSettingsControllerUnderTest;

    @BeforeEach
    void setUp () {
        accountSettingsControllerUnderTest = new AccountSettingsController();
    }

    @Test
    void testRefreshAccountsUpdate () {
        // Setup

        // Run the test
        accountSettingsControllerUnderTest.refreshAccountsUpdate();

        // Verify the results
    }

    @Test
    void testRefreshAccountsRemove () {
        // Setup

        // Run the test
        accountSettingsControllerUnderTest.refreshAccountsRemove();

        // Verify the results
    }

    @Test
    void testRemoveAccount () {
        // Setup

        // Run the test
        accountSettingsControllerUnderTest.removeAccount();

        // Verify the results
    }
}
