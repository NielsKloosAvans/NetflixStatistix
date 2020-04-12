package logic;

import data.Episode;
import data.Series;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EpisodeAverageWatchedSeriesTest {

    private EpisodeAverageWatchedSeries episodeAverageWatchedSeriesUnderTest;

    @BeforeEach
    void setUp() {
        episodeAverageWatchedSeriesUnderTest = new EpisodeAverageWatchedSeries();
        episodeAverageWatchedSeriesUnderTest.database = mock(DBconnection.class);
    }

    @Test
    void testEpisodeGetPercentage() {
        // Setup
        final Series series = new Series(0, "title", "genre", "language", 0, 0, "youMayLike");
        when(episodeAverageWatchedSeriesUnderTest.database.getConnectionUrl()).thenReturn("result");

        // Run the test
        final List<Episode> result = episodeAverageWatchedSeriesUnderTest.episodeGetPercentage(series);

        // Verify the results
    }
}
