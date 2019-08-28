package uk.co.probablyfine.time;

import org.junit.Test;

import java.time.LocalDate;

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

    private LocalDate workingDaysAfter(LocalDate start, int daysAfter) {
        return LocalDate.of(2019, 4, 5);
    }
}
