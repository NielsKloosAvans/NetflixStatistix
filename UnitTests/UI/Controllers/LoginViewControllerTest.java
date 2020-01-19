package UI.Controllers;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginViewControllerTest {

    private LoginViewController loginViewControllerUnderTest;

    @BeforeEach
    void setUp () {
        loginViewControllerUnderTest = new LoginViewController();
    }

    @Test
    void testMakeAccount () {
        // Setup

        // Run the test
        loginViewControllerUnderTest.makeAccount();

        // Verify the results
    }

    @Test
    void testLoginAccount () throws Exception {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        loginViewControllerUnderTest.loginAccount(event);

        // Verify the results
    }

    @Test
    void testLoginAccount_ThrowsIOException () {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        assertThrows(IOException.class, () -> {
            loginViewControllerUnderTest.loginAccount(event);
        });
    }
}
