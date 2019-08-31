package uk.co.probablyfine.time;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import uk.co.probablyfine.time.calendars.HolidayCalendar;

public class WorkingDays {

    private static final LocalDate ARBITRARY_END = LocalDate.of(2099, 1, 1);

    private final HolidayCalendar calendar;

    public WorkingDays(HolidayCalendar calendar) {
        this.calendar = calendar;
    }

    public LocalDate after(LocalDate start, int daysAfter) {
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
}
