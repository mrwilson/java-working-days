package uk.co.probablyfine.time;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.Month;

class WorkingDays {

    private static final LocalDate ARBITRARY_END = LocalDate.of(2099, 1, 1);

    public LocalDate after(LocalDate start, int daysAfter) {
        return start.datesUntil(ARBITRARY_END)
                .filter(not(this::isTheWeekend))
                .filter(not(this::isChristmasDayOrBoxingDay))
                .limit(daysAfter + 1)
                .collect(toList())
                .get(daysAfter);
    }

    private boolean isChristmasDayOrBoxingDay(LocalDate date) {
        int day = date.getDayOfMonth();

        return date.getMonth() == Month.DECEMBER && (day == 25 || day == 26);
    }

    private boolean isTheWeekend(LocalDate date) {
        return date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY;
    }
}
