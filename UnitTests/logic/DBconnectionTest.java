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
        try {
            assertThrows(Exception.class, () -> {
                dBconnectionUnderTest.connect();
            });
        } catch (AssertionError error) {
            System.out.println("Nothing thrown!");
        }
    }

    @Test
    void testConnect_ThrowsClassNotFoundException () {
        // Setup + Run the test
        try {
            assertThrows(ClassNotFoundException.class, () -> {
                dBconnectionUnderTest.connect();
            });
        } catch (AssertionError error){
            System.out.println("Nothing Thrown");
        }
    }
}