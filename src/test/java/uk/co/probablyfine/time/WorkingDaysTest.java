package uk.co.probablyfine.time;

import org.junit.Test;

import java.time.LocalDate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorkingDaysTest {

    @Test
    public void shouldHandleWeekDays() {
        LocalDate workingDays = workingDaysAfter(
                LocalDate.of(2019, 4, 1),
                4
        );

        assertThat(workingDays, is(LocalDate.of(2019, 4, 5)));
    }

    @Test
    public void shouldHandleWeekDaysOverWeekend() {
        LocalDate workingDays = workingDaysAfter(
                LocalDate.of(2019, 4, 1),
                5
        );

        assertThat(workingDays, is(LocalDate.of(2019, 4, 8)));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_NoLeapYear() {
        LocalDate workingDays = workingDaysAfter(
                LocalDate.of(2019, 2, 28),
                1
        );

        assertThat(workingDays, is(LocalDate.of(2019, 3, 1)));
    }

    @Test
    public void shouldHandleWeekDaysOverEndOfFeb_LeapYear() {
        LocalDate workingDays = workingDaysAfter(
                LocalDate.of(2012, 2, 28),
                2
        );

        assertThat(workingDays, is(LocalDate.of(2012, 3, 1)));
    }

    private LocalDate workingDaysAfter(LocalDate start, int daysAfter) {
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
