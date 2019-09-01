package uk.co.probablyfine.time.calendars;

import static uk.co.probablyfine.time.calendars.HolidayCalendar.isTheWeekend;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class UnitedStates implements HolidayCalendar {
    @Override
    public boolean isPublicHoliday(LocalDate date) {
        return isMlkJrDay(date)
                || isPresidentsDay(date)
                || isMemorialDay(date)
                || isIndependenceDay(date)
                || isLaborDay(date)
                || isColumbusDay(date)
                || isVeteransDay(date)
                || isThanksgivingDay(date)
                || isChristmasDay(date);
    }

    private boolean isMlkJrDay(LocalDate date) {
        return date.getMonth() == Month.JANUARY
                && date.getDayOfWeek() == DayOfWeek.MONDAY
                && date.getDayOfMonth() >= 15
                && date.getDayOfMonth() <= 21;
    }

    private boolean isPresidentsDay(LocalDate date) {
        return date.getMonth() == Month.FEBRUARY
                && date.getDayOfWeek() == DayOfWeek.MONDAY
                && date.getDayOfMonth() >= 15
                && date.getDayOfMonth() <= 21;
    }

    private boolean isMemorialDay(LocalDate date) {
        return date.getMonth() == Month.MAY
                && date.getDayOfWeek() == DayOfWeek.MONDAY
                && date.getDayOfMonth() >= 25;
    }

    private boolean isIndependenceDay(LocalDate date) {
        return fixedDateFederalHoliday(4, Month.JULY, date);
    }

    private boolean isLaborDay(LocalDate date) {
        return date.getMonth() == Month.SEPTEMBER
                && date.getDayOfWeek() == DayOfWeek.MONDAY
                && date.getDayOfMonth() <= 7;
    }

    private boolean isColumbusDay(LocalDate date) {
        return date.getMonth() == Month.OCTOBER
                && date.getDayOfWeek() == DayOfWeek.MONDAY
                && date.getDayOfMonth() >= 8
                && date.getDayOfMonth() <= 14;
    }

    private boolean isVeteransDay(LocalDate date) {
        return fixedDateFederalHoliday(11, Month.NOVEMBER, date);
    }

    private boolean isThanksgivingDay(LocalDate date) {
        return date.getMonth() == Month.NOVEMBER
                && date.getDayOfWeek() == DayOfWeek.THURSDAY
                && date.getDayOfMonth() >= 22
                && date.getDayOfMonth() <= 28;
    }

    private boolean isChristmasDay(LocalDate date) {
        return fixedDateFederalHoliday(25, Month.DECEMBER, date);
    }

    private boolean fixedDateFederalHoliday(int day, Month month, LocalDate date) {
        if (date.getMonth() != month) {
            return false;
        }

        boolean asNormal = date.getDayOfMonth() == day && !isTheWeekend(date);
        boolean onSaturday = date.getDayOfMonth() == (day - 1) && date.getDayOfWeek() == DayOfWeek.FRIDAY;
        boolean onSunday = date.getDayOfMonth() == (day + 1) && date.getDayOfWeek() == DayOfWeek.MONDAY;

        return asNormal || onSaturday || onSunday;
    }
}
