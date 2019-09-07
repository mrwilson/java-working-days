package uk.co.probablyfine.time;

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
}
