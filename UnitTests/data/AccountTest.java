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

        try {
            final Profile profile = new Profile("profileName", 0, "email");
            accountUnderTest.AddProfile(profile);
        }
        catch (NullPointerException e){
            System.out.println("NullpointerException caught!");    }
}
    @Test
    void testGetProfile () {
        // Setup
        try {
            // Run the test
            final Profile result = accountUnderTest.getProfile(0);
        } catch (NullPointerException e){
            System.out.println("NullpointerException caught!");
        }
        // Verify the results
    }

    @Test
    void testToString () {
        // Setup

        // Run the test
        final String result = accountUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
