package uk.co.probablyfine.time.calendars;

import static org.junit.Assert.assertTrue;
import static uk.co.probablyfine.time.WorkingDaysHistoricTest.loadExamples;

import java.io.IOException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import uk.co.probablyfine.time.WorkingDaysHistoricTest.Example;

@RunWith(Parameterized.class)
public class EnglandAndWalesHistoricTest {

    @Parameters(name = "{0}")
    public static Collection<Example> data() throws IOException {
        return loadExamples("src/test/resources/historic_dates_england_and_wales.csv");
    }

    private final HolidayCalendar calendar = HolidayCalendar.ENGLAND_AND_WALES;
    private final Example example;

    public EnglandAndWalesHistoricTest(Example example) {
        this.example = example;
    }

    @Test
    public void shouldListHistoricPublicHolidays() {
        String message = String.format("%s was not detected", example);

        assertTrue(message, calendar.isPublicHoliday(example.date));
    }
}
