package uk.co.probablyfine.time.calendars;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;
import static uk.co.probablyfine.time.calendars.Easter.easterSunday;

import java.time.LocalDate;
import java.time.Month;

public class EnglandAndWales implements HolidayCalendar {

    @Override
    public boolean isPublicHoliday(LocalDate date) {
        return isNewYearsDay(date)
                || isMayDayBankHoliday(date)
                || isEndOfMayBankHoliday(date)
                || isGoodFriday(date)
                || isEasterMonday(date)
                || isAugustBankHoliday(date)
                || isChristmasDay(date)
                || isBoxingDay(date)
                || isSpecialBankHoliday(date);
    }

    private boolean isEndOfMayBankHoliday(LocalDate date) {
        boolean asNormal =
                date.getYear() != 2012
                        && date.getMonth() == Month.MAY
                        && date.getDayOfWeek() == MONDAY
                        && date.getDayOfMonth() >= 25;

        boolean diamondJubilee =
                date.getYear() == 2012
                        && date.getMonth() == Month.JUNE
                        && date.getDayOfMonth() == 4;

        return asNormal || diamondJubilee;
    }

    private boolean isSpecialBankHoliday(LocalDate date) {
        boolean diamondJubilee =
                date.getYear() == 2012
                        && date.getMonth() == Month.JUNE
                        && date.getDayOfMonth() == 5;

        return diamondJubilee;
    }

    private boolean isGoodFriday(LocalDate date) {
        return date.getDayOfMonth() == easterSunday(date.getYear()).minusDays(2).getDayOfMonth();
    }

    private boolean isEasterMonday(LocalDate date) {
        return date.getDayOfMonth() == easterSunday(date.getYear()).plusDays(1).getDayOfMonth();
    }

    private boolean isMayDayBankHoliday(LocalDate date) {
        boolean asNormal =
                date.getYear() != 2020
                        && date.getMonth() == Month.MAY
                        && date.getDayOfWeek() == MONDAY
                        && date.getDayOfMonth() <= 7;

        boolean veDay =
                date.getYear() == 2020 && date.getMonth() == Month.MAY && date.getDayOfMonth() == 8;

        return asNormal || veDay;
    }

    private boolean isAugustBankHoliday(LocalDate date) {
        return date.getMonth() == Month.AUGUST
                && date.getDayOfWeek() == MONDAY
                && date.getDayOfMonth() >= 25;
    }

    private boolean isNewYearsDay(LocalDate date) {
        if (date.getMonth() != Month.JANUARY) {
            return false;
        }

        boolean duringTheWeek = date.getDayOfMonth() == 1 && !HolidayCalendar.isTheWeekend(date);
        boolean onSaturday = date.getDayOfWeek() == MONDAY && date.getDayOfMonth() == 3;
        boolean onSunday = date.getDayOfWeek() == MONDAY && date.getDayOfMonth() == 2;

        return duringTheWeek || onSaturday || onSunday;
    }

    private boolean isChristmasDay(LocalDate date) {
        if (date.getMonth() != Month.DECEMBER) {
            return false;
        }

        boolean christmasDuringTheWeek =
                date.getDayOfMonth() == 25 && !HolidayCalendar.isTheWeekend(date);
        boolean christmasOnSunday = date.getDayOfMonth() == 26 && date.getDayOfWeek() == MONDAY;
        boolean christmasOnSaturday = date.getDayOfMonth() == 27 && date.getDayOfWeek() == MONDAY;

        return christmasDuringTheWeek || christmasOnSunday || christmasOnSaturday;
    }

    private boolean isBoxingDay(LocalDate date) {
        if (date.getMonth() != Month.DECEMBER) {
            return false;
        }

        boolean christmasDuringTheWeek =
                date.getDayOfMonth() == 26 && !HolidayCalendar.isTheWeekend(date);
        boolean christmasOnSunday = date.getDayOfMonth() == 27 && date.getDayOfWeek() == TUESDAY;
        boolean christmasOnSaturday = date.getDayOfMonth() == 28 && date.getDayOfWeek() == TUESDAY;
        boolean christmasOnFriday = date.getDayOfMonth() == 28 && date.getDayOfWeek() == MONDAY;

        return christmasDuringTheWeek
                || christmasOnSunday
                || christmasOnSaturday
                || christmasOnFriday;
    }
}
