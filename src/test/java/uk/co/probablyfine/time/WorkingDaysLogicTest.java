package uk.co.probablyfine.time;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import org.junit.Test;
import uk.co.probablyfine.time.calendars.HolidayCalendar;

public class WorkingDaysLogicTest implements WorkingDaysTest {

    private final HolidayCalendar noPublicHolidays = date -> false;

    private final WorkingDays workingDays = WorkingDays.usingCalendar(noPublicHolidays);

    @Override
    public WorkingDays objectUnderTest() {
        return this.workingDays;
    }

    @Test
    public void shouldHandleTheSameDate() {
        LocalDate date = date(2019, 4, 1);

        assertWorkingDaysRelationship(date, 0, date);
    }

    @Test
    public void negativeDaysBeforeBecomesDaysAfter() {
        LocalDate date = date(2019, 4, 1);

        assertThat(workingDays.daysBefore(date, -1), is(date.plusDays(1)));
    }

    @Test
    public void negativeDaysAfterBecomesDaysBefore() {
        LocalDate date = date(2019, 4, 2);

        assertThat(workingDays.daysAfter(date, -1), is(date.minusDays(1)));
    }

    @Test
    public void negativeDaysBetweenWhereEndIsBeforeStart() {
        LocalDate start = date(2019, 4, 2);
        LocalDate end = date(2019, 4, 1);

        assertThat(workingDays.daysBetween(start, end), is(-1));
    }

    @Test
    public void daysBeforeThrowsExceptionWhenInputDateIsNull() {
        try {
            workingDays.daysBefore(null, 1);
            fail("Expected an exception, didn't get one");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Input 'end' should not be null"));
        }
    }

    @Test
    public void daysAfterThrowsExceptionWhenInputDateIsNull() {
        try {
            workingDays.daysAfter(null, 1);
            fail("Expected an exception, didn't get one");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Input 'start' should not be null"));
        }
    }
}
