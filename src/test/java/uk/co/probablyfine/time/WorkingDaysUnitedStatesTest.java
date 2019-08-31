package uk.co.probablyfine.time;

import org.junit.Test;
import uk.co.probablyfine.time.calendars.HolidayCalendar;

public class WorkingDaysUnitedStatesTest implements WorkingDaysTest {

    @Override
    public WorkingDays objectUnderTest() {
        return WorkingDays.usingCalendar(HolidayCalendar.UNITED_STATES);
    }

    @Test
    public void shouldHandleMartinLutherKingJrDay() {
        // MLK Jr day was 21st January in 2019
        assertWorkingDaysRelationship(date(2019, 1, 18), 1, date(2019, 1, 22));

        // MLK Jr day is 20th January in 2020
        assertWorkingDaysRelationship(date(2020, 1, 17), 1, date(2020, 1, 21));
    }

    @Test
    public void shouldHandlePresidentsDay() {
        // President's Day was 18th February in 2019
        assertWorkingDaysRelationship(date(2019, 2, 15), 1, date(2019, 2, 19));

        // President's Day is 17th February in 2020
        assertWorkingDaysRelationship(date(2020, 2, 14), 1, date(2020, 2, 18));
    }
}
