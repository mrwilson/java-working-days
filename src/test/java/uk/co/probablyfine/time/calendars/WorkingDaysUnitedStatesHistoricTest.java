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
public class WorkingDaysUnitedStatesHistoricTest {

    @Parameters(name = "{0}")
    public static Collection<Example> data() throws IOException {
        return loadExamples("src/test/resources/historic_dates_united_states.csv");
    }

    private final HolidayCalendar calendar = HolidayCalendar.UNITED_STATES;
    private final Example example;

    public WorkingDaysUnitedStatesHistoricTest(Example example) {
        this.example = example;
    }

    @Test
    public void shouldListHistoricPublicHolidays() {
        String message = String.format("%s was not detected", example);

        switch (example.date.getDayOfWeek()) {
            case SATURDAY:
                assertTrue(message, calendar.isPublicHoliday(example.date.minusDays(1)));
                break;
            case SUNDAY:
                assertTrue(message, calendar.isPublicHoliday(example.date.plusDays(1)));
                break;
            default:
                assertTrue(message, calendar.isPublicHoliday(example.date));
        }
    }
}
