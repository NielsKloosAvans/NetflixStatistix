package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private Account accountUnderTest;

    @BeforeEach
    void setUp () {
        accountUnderTest = new Account("email", "name", "password", "address", "city");
    }

    @Test
    void testAddProfile () {
        // Setup
        final Profile profile = new Profile("profileName", 0, "email");

        // Run the test
        accountUnderTest.addProfile(profile);

        // Verify the results
    }

    @Test
    void testGetProfile () {
        // Setup
        try {
            final Profile result = accountUnderTest.getProfile(0);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Arraylist is empty!");
        }

        // Verify the results
    }

    @Test
    void testToString () {
        // Setup

        // Run the test
        final String result = accountUnderTest.toString();

        // Verify the results
        assertEquals("Account: email", result);
    }
}
