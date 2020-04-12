package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DBconnectionTest {

    private DBconnection dBconnectionUnderTest;

    @BeforeEach
    void setUp() {
        dBconnectionUnderTest = new DBconnection();
    }


    @Test
    void testConnect_ThrowsClassNotFoundException() {
        // Setup

        // Run the test
        assertThrows(ClassNotFoundException.class, () -> {
            dBconnectionUnderTest.connect();
        });
    }
}
