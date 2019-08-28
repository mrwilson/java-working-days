package uk.co.probablyfine.time;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import org.junit.Test;

public class WorkingDaysTest {

    private final WorkingDays workingDays = new WorkingDays();

    @Test
    public void shouldHandleWeekDays() {
        LocalDate fourDaysAfter = workingDays.after(date(2019, 4, 1), 4);

        assertThat(fourDaysAfter, is(date(2019, 4, 5)));
    }

    @Test
    public void shouldHandleWeekDaysOverWeekend() {
        LocalDate fiveDaysAfter = workingDays.after(date(2019, 4, 1), 5);

        assertThat(fiveDaysAfter, is(date(2019, 4, 8)));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_NoLeapYear() {
        LocalDate theNextDay = workingDays.after(date(2019, 2, 28), 1);

        assertThat(theNextDay, is(date(2019, 3, 1)));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_LeapYear() {
        LocalDate twoDaysAfter = workingDays.after(date(2012, 2, 28), 2);

        assertThat(twoDaysAfter, is(date(2012, 3, 1)));
    }

    @Test
    public void shouldHandleChristmasBankHolidays() {
        LocalDate dayAfter = workingDays.after(date(2019, 12, 24), 1);

        assertThat(dayAfter, is(date(2019, 12, 27)));
    }

    @Test
    public void shouldHandleNewYearsDay() {
        LocalDate dayAfter = workingDays.after(date(2019, 12, 31), 1);

        assertThat(dayAfter, is(date(2020, 1, 2)));
    }

    private LocalDate date(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
