package logic;

import data.Series;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SeriesQueriesTest {

    private SeriesQueries seriesQueriesUnderTest;

    @BeforeEach
    void setUp() {
        seriesQueriesUnderTest = new SeriesQueries();
    }

    @Test
    void testGetAll() {
        // Setup

        // Run the test
        final List<Series> result = seriesQueriesUnderTest.getAll();

        // Verify the results
    }
}
