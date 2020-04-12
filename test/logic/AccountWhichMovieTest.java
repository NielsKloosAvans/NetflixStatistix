package logic;

import data.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountWhichMovieTest {

    private AccountWhichMovie accountWhichMovieUnderTest;

    @BeforeEach
    void setUp() {
        accountWhichMovieUnderTest = new AccountWhichMovie();
        accountWhichMovieUnderTest.database = mock(DBconnection.class);
    }

    @Test
    void testGetAll() {
        // Setup
        when(accountWhichMovieUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Movie> result = accountWhichMovieUnderTest.getAll("email");

        // Verify the results
    }
}
