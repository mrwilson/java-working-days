package uk.co.probablyfine.time;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import org.junit.Test;

public class WorkingDaysTest {

    private final WorkingDays wDays = new WorkingDays();

    @Test
    public void shouldHandleWeekDays() {
        LocalDate workingDays = wDays.after(date(2019, 4, 1), 4);

        assertThat(workingDays, is(date(2019, 4, 5)));
    }

    @Test
    public void shouldHandleWeekDaysOverWeekend() {
        LocalDate workingDays = wDays.after(date(2019, 4, 1), 5);

        assertThat(workingDays, is(date(2019, 4, 8)));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_NoLeapYear() {
        LocalDate workingDays = wDays.after(date(2019, 2, 28), 1);

        assertThat(workingDays, is(date(2019, 3, 1)));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_LeapYear() {
        LocalDate workingDays = wDays.after(date(2012, 2, 28), 2);

        assertThat(workingDays, is(date(2012, 3, 1)));
    }

    private static class WorkingDays {

        private LocalDate after(LocalDate start, int daysAfter) {
            return start.datesUntil(LocalDate.of(2099, 1, 1))
                    .filter(this::isAWeekDay)
                    .limit(daysAfter + 1)
                    .collect(toList())
                    .get(daysAfter);
        }

        private boolean isAWeekDay(LocalDate date) {
            return !(date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY);
        }
    }

    private LocalDate date(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
