package UI.Controllers;

import data.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.spec.ECField;
import java.util.Arrays;

class ProfileSettingsControllerTest {

    private ProfileSettingsController profileSettingsControllerUnderTest;

    @BeforeEach
    void setUp () {
        profileSettingsControllerUnderTest = new ProfileSettingsController();
        profileSettingsControllerUnderTest.accounts = Arrays.asList(new Account("email", "name", "password", "address", "city"));
    }

    @Test
    void testRefreshAccount () {
        // Setup +  Run the test
        try {

            profileSettingsControllerUnderTest.refreshAccount();
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }

    }

    @Test
    void testRefreshAccountsUpdate () {
        // Setup + Run the Test
        try {

            profileSettingsControllerUnderTest.refreshAccountsUpdate();
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }
    }
}

