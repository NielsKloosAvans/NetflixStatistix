package data;

import org.junit.jupiter.api.BeforeEach;

class EpisodeTest {

    private Episode episodeUnderTest;

    @BeforeEach
    void setUp () {
        episodeUnderTest = new Episode("episodeTitle", 0, 0, 0, 0);
    }
}
