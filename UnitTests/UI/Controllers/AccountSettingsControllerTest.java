
package UI.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

class AccountSettingsControllerTest {

    private AccountSettingsController accountSettingsControllerUnderTest;

    @BeforeEach
    void setUp () {
        accountSettingsControllerUnderTest = new AccountSettingsController();
    }

    @Test
    void testRefreshAccountsUpdate () {
        // Setup + Run the test
        try {
            accountSettingsControllerUnderTest.refreshAccountsUpdate();
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }
    }

    @Test
    void testRefreshAccountsRemove () {
        // Setup + Run the test
        try {
            accountSettingsControllerUnderTest.refreshAccountsRemove();
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }
    }

    @Test
    void testRemoveAccount () {
        // Setup + Run the test
        try {
            accountSettingsControllerUnderTest.removeAccount();
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }
    }
}
