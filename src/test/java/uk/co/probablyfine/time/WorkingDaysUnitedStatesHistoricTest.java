package uk.co.probablyfine.time;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import uk.co.probablyfine.time.calendars.HolidayCalendar;

@RunWith(Parameterized.class)
public class WorkingDaysUnitedStatesHistoricTest {

    private Example example;

    @Parameters(name = "{0}")
    public static Iterable<Object> data() throws IOException {
        return Files.readAllLines(UNITED_STATES).stream()
                .map(WorkingDaysUnitedStatesHistoricTest::toExample)
                .collect(Collectors.toList());
    }

    private static final Path UNITED_STATES =
            Paths.get("src/test/resources/historic_dates_united_states.csv");
    private static final HolidayCalendar calendar = HolidayCalendar.UNITED_STATES;

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

    private static Example toExample(String input) {
        String[] split = input.split(",");
        return new Example(split[0], LocalDate.parse(split[1]));
    }

    static class Example {
        final String name;
        final LocalDate date;

        Example(String name, LocalDate date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return String.format("%s %s", name, date);
        }
    }
}
