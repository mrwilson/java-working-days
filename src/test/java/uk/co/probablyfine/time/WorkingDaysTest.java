package uk.co.probablyfine.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Collectors;

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

    private LocalDate workingDaysAfter(LocalDate start, int daysAfter) {

        return start.datesUntil(LocalDate.of(2099, 1, 1))
                .filter(date -> !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY))
                .limit(daysAfter + 1)
                .collect(Collectors.toList())
                .get(daysAfter);
    }


}
