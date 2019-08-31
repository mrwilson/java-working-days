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
                || isIndependenceDay(date);
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
        if (date.getMonth() != Month.JULY) {
            return false;
        }

        boolean asNormal = date.getDayOfMonth() == 4 && !isTheWeekend(date);
        boolean onSaturday = date.getDayOfMonth() == 3 && date.getDayOfWeek() == DayOfWeek.FRIDAY;
        boolean onSunday = date.getDayOfMonth() == 5 && date.getDayOfWeek() == DayOfWeek.MONDAY;

        return asNormal || onSaturday || onSunday;
    }
}
