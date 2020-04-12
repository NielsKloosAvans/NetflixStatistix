package logic;

import data.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountQueriesTest {

    private AccountQueries accountQueriesUnderTest;

    @BeforeEach
    void setUp() {
        accountQueriesUnderTest = new AccountQueries();
    }


    @Test
    void testGetAll() {
        // Setup

        // Run the test
        final List<Account> result = accountQueriesUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetEmail() {
        // Setup

        // Run the test
        final List<Account> result = accountQueriesUnderTest.getEmail();

        // Verify the results
    }
}
