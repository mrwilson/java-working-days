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
                .filter(not(this::isMayDayBankHoliday))
                .limit(daysAfter + 1)
                .collect(toList())
                .get(daysAfter);
    }

    private boolean isMayDayBankHoliday(LocalDate date) {
        return date.getMonth() == Month.MAY
                && date.getDayOfWeek() == MONDAY
                && date.getDayOfMonth() <= 7;
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
        if (date.getMonth() != Month.DECEMBER) {
            return false;
        }

        boolean christmasDuringTheWeek = date.getDayOfMonth() == 25 && !isTheWeekend(date);
        boolean christmasOnSunday = date.getDayOfMonth() == 26 && date.getDayOfWeek() == MONDAY;
        boolean christmasOnSaturday = date.getDayOfMonth() == 27 && date.getDayOfWeek() == MONDAY;

        return christmasDuringTheWeek || christmasOnSunday || christmasOnSaturday;
    }

    private boolean isBoxingDay(LocalDate date) {
        if (date.getMonth() != Month.DECEMBER) {
            return false;
        }

        boolean christmasDuringTheWeek = date.getDayOfMonth() == 26 && !isTheWeekend(date);
        boolean christmasOnSunday = date.getDayOfMonth() == 27 && date.getDayOfWeek() == TUESDAY;
        boolean christmasOnSaturday = date.getDayOfMonth() == 28 && date.getDayOfWeek() == TUESDAY;

        return christmasDuringTheWeek || christmasOnSunday || christmasOnSaturday;
    }

    private boolean isTheWeekend(LocalDate date) {
        return date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY;
    }
}
