package logic;

import data.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountOneProfileTest {

    private AccountOneProfile accountOneProfileUnderTest;

    @BeforeEach
    void setUp() {
        accountOneProfileUnderTest = new AccountOneProfile();
        accountOneProfileUnderTest.database = mock(DBconnection.class);
    }

    @Test
    void testGetAll() {
        // Setup
        when(accountOneProfileUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Account> result = accountOneProfileUnderTest.getAll();

        // Verify the results
    }
}
