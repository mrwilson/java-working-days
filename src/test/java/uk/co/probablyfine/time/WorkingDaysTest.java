package uk.co.probablyfine.time;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

public interface WorkingDaysTest {

    WorkingDays objectUnderTest();

    default void assertWorkingDaysRelationship(LocalDate start, int days, LocalDate end) {
        LocalDate expectedEnd = objectUnderTest().daysAfter(start, days);
        LocalDate expectedStart = objectUnderTest().daysBefore(end, days);
        int expectedDaysBetween = objectUnderTest().daysBetween(start, end);

        assertThat(expectedEnd, is(end));
        assertThat(expectedDaysBetween, is(days));
        assertThat(expectedStart, is(start));
    }

    default LocalDate date(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
