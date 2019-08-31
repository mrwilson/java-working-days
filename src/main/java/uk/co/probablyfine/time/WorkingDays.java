package uk.co.probablyfine.time;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.Period;
import uk.co.probablyfine.time.calendars.HolidayCalendar;

public class WorkingDays {

    private static final LocalDate ARBITRARY_END = LocalDate.of(2099, 1, 1);
    private static final LocalDate ARBITRARY_START = LocalDate.of(1970, 1, 1);
    private static final Period REVERSE_ORDER = Period.ofDays(-1);

    private final HolidayCalendar calendar;

    private WorkingDays(HolidayCalendar calendar) {
        this.calendar = calendar;
    }

    public static WorkingDays usingCalendar(HolidayCalendar calendar) {
        return new WorkingDays(calendar);
    }

    public LocalDate daysAfter(LocalDate start, int daysAfter) {
        return start.datesUntil(ARBITRARY_END)
                .filter(not(HolidayCalendar::isTheWeekend))
                .filter(not(calendar::isPublicHoliday))
                .limit(daysAfter + 1)
                .collect(toList())
                .get(daysAfter);
    }

    public int daysBetween(LocalDate start, LocalDate end) {
        return start.datesUntil(end)
                .filter(not(HolidayCalendar::isTheWeekend))
                .filter(not(calendar::isPublicHoliday))
                .collect(toList())
                .size();
    }

    public LocalDate daysBefore(LocalDate end, int daysBefore) {
        return end.datesUntil(ARBITRARY_START, REVERSE_ORDER)
                .filter(not(HolidayCalendar::isTheWeekend))
                .filter(not(calendar::isPublicHoliday))
                .limit(daysBefore + 1)
                .collect(toList())
                .get(daysBefore);
    }
}
