package logic;

import data.Episode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EpisodeAverageWatchedSeriesTest {

    private EpisodeAverageWatchedSeries episodeAverageWatchedSeriesUnderTest;

    @BeforeEach
    void setUp () {
        episodeAverageWatchedSeriesUnderTest = new EpisodeAverageWatchedSeries();
        episodeAverageWatchedSeriesUnderTest.database = mock(DBconnection.class);
    }


}
