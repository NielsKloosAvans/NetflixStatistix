
package logic;

import data.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountQueriesTest {

    private AccountQueries accountQueriesUnderTest;

    @BeforeEach
    void setUp () {
        accountQueriesUnderTest = new AccountQueries();
    }

    @Test
    void testCreateAccount () {
        // Setup

        // Run the test
        final boolean result = accountQueriesUnderTest.createAccount("name", "email", "password", "address", "city");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testUpdateAccount () {
        // Setup
        final Account account = new Account("email", "name", "password", "address", "city");

        // Run the test
        final boolean result = accountQueriesUnderTest.updateAccount(account);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testDeleteAccount () {
        // Setup
        final Account account = new Account("email", "name", "password", "address", "city");

        // Run the test
        final boolean result = accountQueriesUnderTest.deleteAccount(account);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testLoginAccount () {
        // Setup

        // Run the test
        final boolean result = accountQueriesUnderTest.loginAccount("email", "password");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testGetAll () {
        // Setup

        // Run the test
        final List<Account> result = accountQueriesUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetEmail () {
        // Setup

        // Run the test
        final List<Account> result = accountQueriesUnderTest.getEmail();

        // Verify the results
    }
}
