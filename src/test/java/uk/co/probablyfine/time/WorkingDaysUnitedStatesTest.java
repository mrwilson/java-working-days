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

    @Test
    public void shouldHandleMemorialDay() {
        // Memorial Day was 27th May in 2019
        assertWorkingDaysRelationship(date(2019, 5, 24), 1, date(2019, 5, 28));

        // Memorial Day is 25th May in 2020
        assertWorkingDaysRelationship(date(2020, 5, 22), 1, date(2020, 5, 26));
    }

    @Test
    public void shouldHandleIndependenceDay() {
        // Independence Day was 4th July in 2019
        assertWorkingDaysRelationship(date(2019, 7, 3), 1, date(2019, 7, 5));

        // Independence Day is observed on 3rd July in 2020
        assertWorkingDaysRelationship(date(2020, 7, 2), 1, date(2020, 7, 6));

        // Independence Day is observed on 5th July in 2021
        assertWorkingDaysRelationship(date(2021, 7, 2), 1, date(2021, 7, 6));
    }

    @Test
    public void shouldHandleLaborDay() {
        // Labor Day is observed on 2nd September in 2019
        assertWorkingDaysRelationship(date(2019, 8, 30), 1, date(2019, 9, 3));

        // Labor Day is observed on 7th September in 2020
        assertWorkingDaysRelationship(date(2020, 9, 4), 1, date(2020, 9, 8));
    }

    @Test
    public void shouldHandleColumbusDay() {
        // Columbus Day is observed on 14th October in 2019
        assertWorkingDaysRelationship(date(2019, 10, 11), 1, date(2019, 10, 15));

        // Columbus Day is observed on 14th October in 2020
        assertWorkingDaysRelationship(date(2020, 10, 9), 1, date(2020, 10, 13));
    }

    @Test
    public void shouldHandleVeteransDay() {
        // Columbus Day is observed on 11th November in 2019
        assertWorkingDaysRelationship(date(2019, 11, 8), 1, date(2019, 11, 12));

        // Columbus Day was observed on 10th November in 2017
        assertWorkingDaysRelationship(date(2017, 11, 9), 1, date(2017, 11, 13));

        // Columbus Day was observed on 12th November in 2018
        assertWorkingDaysRelationship(date(2018, 11, 9), 1, date(2018, 11, 13));
    }

    @Test
    public void shouldHandleThanksgivingDay() {
        // Thanksgiving Day is observed on 28th November in 2019
        assertWorkingDaysRelationship(date(2019, 11, 27), 1, date(2019, 11, 29));

        // Thanksgiving Day is observed on 26th November in 2020
        assertWorkingDaysRelationship(date(2020, 11, 25), 1, date(2020, 11, 27));

        // Thanksgiving Day is observed on 25th November in 2021
        assertWorkingDaysRelationship(date(2021, 11, 24), 1, date(2021, 11, 26));
    }
}
