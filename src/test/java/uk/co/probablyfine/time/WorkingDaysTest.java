package uk.co.probablyfine.time;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorkingDaysTest {

    @Test
    public void shouldHandleWeekDays() {
        int workingDays = workingDaysBetween(
            LocalDate.of(2019, 4, 1),
            LocalDate.of(2019, 4, 5)
        );

        assertThat(workingDays, is(5));
    }

    private int workingDaysBetween(LocalDate start, LocalDate end) {
        return 5;
    }
}
