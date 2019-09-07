package uk.co.probablyfine.time.calendars;

import static uk.co.probablyfine.time.calendars.HolidayCalendar.ENGLAND_AND_WALES;

import org.junit.Test;
import uk.co.probablyfine.time.WorkingDays;
import uk.co.probablyfine.time.WorkingDaysTest;

public class WorkingDaysEnglandAndWalesTest implements WorkingDaysTest {

    private final WorkingDays workingDays = WorkingDays.usingCalendar(ENGLAND_AND_WALES);

    @Override
    public WorkingDays objectUnderTest() {
        return this.workingDays;
    }

    @Test
    public void shouldHandleWeekDays() {
        assertWorkingDaysRelationship(date(2019, 4, 1), 4, date(2019, 4, 5));
    }

    @Test
    public void shouldHandleWeekDaysOverWeekend() {
        assertWorkingDaysRelationship(date(2019, 4, 1), 5, date(2019, 4, 8));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_NoLeapYear() {
        assertWorkingDaysRelationship(date(2019, 2, 28), 1, date(2019, 3, 1));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_LeapYear() {
        assertWorkingDaysRelationship(date(2012, 2, 28), 2, date(2012, 3, 1));
    }

    @Test
    public void shouldHandleChristmasBankHolidays() {
        assertWorkingDaysRelationship(date(2019, 12, 24), 1, date(2019, 12, 27));
    }

    @Test
    public void shouldHandleNewYearsDay() {
        assertWorkingDaysRelationship(date(2019, 12, 31), 1, date(2020, 1, 2));
    }

    @Test
    public void shouldHandleNewYearsDayOnSaturday() {
        assertWorkingDaysRelationship(date(2021, 12, 31), 1, date(2022, 1, 4));
    }

    @Test
    public void shouldHandleNewYearsDayOnSunday() {
        assertWorkingDaysRelationship(date(2016, 12, 30), 1, date(2017, 1, 3));
    }

    @Test
    public void shouldHandleWhenChristmasAndNewYearBothFallAtTheWeekend() {
        assertWorkingDaysRelationship(date(2021, 12, 24), 1, date(2021, 12, 29));
    }

    @Test
    public void shouldHandleWhenChristmasFallsOnSunday() {
        assertWorkingDaysRelationship(date(2022, 12, 23), 1, date(2022, 12, 28));
    }

    @Test
    public void shouldHandleMovingBankHoliday_August() {
        // Aug Bank Holiday is the 26th in 2019
        assertWorkingDaysRelationship(date(2019, 8, 23), 1, date(2019, 8, 27));

        // Aug Bank Holiday is the 31st in 2020
        assertWorkingDaysRelationship(date(2020, 8, 28), 1, date(2020, 9, 1));

        // Aug Bank Holiday is the 30th in 2021
        assertWorkingDaysRelationship(date(2021, 8, 27), 1, date(2021, 8, 31));
    }

    @Test
    public void shouldHandleMovingBankHoliday_May() {
        // May Bank Holiday is the 6th in 2019
        assertWorkingDaysRelationship(date(2019, 5, 3), 1, date(2019, 5, 7));

        // May Bank Holiday is the 1st in 2028
        assertWorkingDaysRelationship(date(2028, 4, 28), 1, date(2028, 5, 2));

        // May Bank Holiday is the 7th in 2029
        assertWorkingDaysRelationship(date(2029, 5, 4), 1, date(2029, 5, 8));
    }

    @Test
    public void shouldHandleMovingBankHoliday_EndOfMay() {
        // End of May Bank Holiday is the 27th in 2019
        assertWorkingDaysRelationship(date(2019, 5, 24), 1, date(2019, 5, 28));
    }

    @Test
    public void shouldHandleMovingBankHoliday_Easter() {
        // Easter Sunday is the 21st in 2019
        assertWorkingDaysRelationship(date(2019, 4, 18), 1, date(2019, 4, 23));
    }
}
