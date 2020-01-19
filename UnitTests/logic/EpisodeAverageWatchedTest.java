package logic;

import data.Episode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EpisodeAverageWatchedTest {

    private EpisodeAverageWatched episodeAverageWatchedUnderTest;

    @BeforeEach
    void setUp () {
        episodeAverageWatchedUnderTest = new EpisodeAverageWatched();
        episodeAverageWatchedUnderTest.database = mock(DBconnection.class);
    }

    @Test
    void testEpisodeAverageWatched () {
        // Setup
        when(episodeAverageWatchedUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Episode> result = episodeAverageWatchedUnderTest.episodeAverageWatched(0, "email");

        // Verify the results
    }
}
