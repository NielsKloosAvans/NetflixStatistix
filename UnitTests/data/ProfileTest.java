package data;

import org.junit.jupiter.api.BeforeEach;

class ProfileTest {

    private Profile profileUnderTest;

    @BeforeEach
    void setUp () {
        profileUnderTest = new Profile("profileName", 0, "email");
    }
}
