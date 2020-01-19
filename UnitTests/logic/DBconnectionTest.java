package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DBconnectionTest {

    private DBconnection dBconnectionUnderTest;

    @BeforeEach
    void setUp () {
        dBconnectionUnderTest = new DBconnection();
    }

    @Test
    void testConnect () throws Exception {
        // Setup

        // Run the test
        dBconnectionUnderTest.connect();

        // Verify the results
    }

    @Test
    void testConnect_ThrowsSQLException () {
        // Setup

        // Run the test
        assertThrows(Exception.class, () -> {
            dBconnectionUnderTest.connect();
        });
    }

    @Test
    void testConnect_ThrowsClassNotFoundException () {
        // Setup

        // Run the test
        assertThrows(ClassNotFoundException.class, () -> {
            dBconnectionUnderTest.connect();
        });
    }

    @Test
    void testCloseConnection () throws Exception {
        // Setup

        // Run the test
        dBconnectionUnderTest.CloseConnection();

        // Verify the results
    }

    @Test
    void testCloseConnection_ThrowsSQLException () {
        // Setup

        // Run the test
        assertThrows(NullPointerException.class, () -> {
            dBconnectionUnderTest.CloseConnection();
        });
    }

    @Test
    void testReadQuery () throws Exception {
        // Setup

        // Run the test
        final ResultSet result = dBconnectionUnderTest.readQuery("SQL");

        // Verify the results
    }

    @Test
    void testReadQuery_ThrowsException () {
        // Setup

        // Run the test
        assertThrows(Exception.class, () -> {
            dBconnectionUnderTest.readQuery("SQL");
        });
    }

    @Test
    void testQueryExecute () throws Exception {
        // Setup

        // Run the test
        dBconnectionUnderTest.queryExecute("SQL");

        // Verify the results
    }

    @Test
    void testQueryExecute_ThrowsException () {
        // Setup

        // Run the test
        assertThrows(Exception.class, () -> {
            dBconnectionUnderTest.queryExecute("SQL");
        });
    }

    @Test
    void testUpdateQuery () throws Exception {
        // Setup

        // Run the test
        final int result = dBconnectionUnderTest.updateQuery("SQL");

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testUpdateQuery_ThrowsException () {
        // Setup

        // Run the test
        assertThrows(Exception.class, () -> {
            dBconnectionUnderTest.updateQuery("SQL");
        });
    }
}
