package logic;

import data.Account;
import data.Episode;
import data.Series;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EpisodeAverageWatchedTest {

    private EpisodeAverageWatched episodeAverageWatchedUnderTest;

    @BeforeEach
    void setUp() {
        episodeAverageWatchedUnderTest = new EpisodeAverageWatched();
        episodeAverageWatchedUnderTest.database = mock(DBconnection.class);
    }

    @Test
    void testEpisodeGetPercentage() {
        // Setup
        final Series series = new Series(0, "title", "genre", "language", 0, 0, "youMayLike");
        final Account account = new Account("email", "name", "password", "address", "city");
        when(episodeAverageWatchedUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Episode> result = episodeAverageWatchedUnderTest.episodeGetPercentage(series, account);

        // Verify the results
    }
}
