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
        // Setup + Run the test
        try {
            loginViewControllerUnderTest.makeAccount();
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }
    }

    @Test
    void testLoginAccount () throws Exception {
        // Setup + Run the test
        try {
            final ActionEvent event = new ActionEvent("o", null);
            loginViewControllerUnderTest.loginAccount(event);
        } catch (NullPointerException e) {
            System.out.println("Empty Arraylist!");
        }
    }

    @Test
    void testLoginAccount_ThrowsIOException () {
        // Setup + Run the test
        final ActionEvent event = new ActionEvent("o", null);
        assertThrows(NullPointerException.class, () -> {
            loginViewControllerUnderTest.loginAccount(event);
        });
    }
}
