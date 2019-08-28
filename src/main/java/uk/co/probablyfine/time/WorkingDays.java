package uk.co.probablyfine.time;

import static java.time.DayOfWeek.*;
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
                .filter(not(this::isNewYearsDay))
                .filter(not(this::isAugustBankHoliday))
                .limit(daysAfter + 1)
                .collect(toList())
                .get(daysAfter);
    }

    private boolean isAugustBankHoliday(LocalDate date) {
        return date.getMonth() == Month.AUGUST
                && date.getDayOfWeek() == MONDAY
                && date.getDayOfMonth() >= 25;
    }

    private boolean isNewYearsDay(LocalDate date) {
        return date.getMonth() == Month.JANUARY && date.getDayOfMonth() == 1;
    }

    private boolean isChristmasDayOrBoxingDay(LocalDate date) {
        return isChristmasDay(date) || isBoxingDay(date);
    }

    private boolean isChristmasDay(LocalDate date) {

        boolean isNonWeekend =
                date.getMonth() == Month.DECEMBER
                        && date.getDayOfMonth() == 25
                        && !isTheWeekend(date);
        boolean isChristmasInLieu =
                date.getMonth() == Month.DECEMBER
                        && date.getDayOfMonth() == 26
                        && date.getDayOfWeek() == MONDAY;
        boolean isChristmasInLieu2 =
                date.getMonth() == Month.DECEMBER
                        && date.getDayOfMonth() == 27
                        && date.getDayOfWeek() == MONDAY;

        return isNonWeekend || isChristmasInLieu || isChristmasInLieu2;
    }

    private boolean isBoxingDay(LocalDate date) {
        boolean isNonWeekend =
                date.getMonth() == Month.DECEMBER
                        && date.getDayOfMonth() == 26
                        && !isTheWeekend(date);
        boolean isBoxingDayInLieu =
                date.getMonth() == Month.DECEMBER
                        && date.getDayOfMonth() == 28
                        && date.getDayOfWeek() == TUESDAY;
        boolean isBoxingDayInLieu2 =
                date.getMonth() == Month.DECEMBER
                        && date.getDayOfMonth() == 27
                        && date.getDayOfWeek() == TUESDAY;

        return isNonWeekend || isBoxingDayInLieu || isBoxingDayInLieu2;
    }

    private boolean isTheWeekend(LocalDate date) {
        return date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY;
    }
}
