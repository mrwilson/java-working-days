package uk.co.probablyfine.time.calendars;

import static java.time.DayOfWeek.MONDAY;
import static uk.co.probablyfine.time.calendars.Easter.easterSunday;

import java.time.LocalDate;
import java.time.Month;

public class France implements HolidayCalendar {
    @Override
    public boolean isPublicHoliday(LocalDate date) {
        return isNewYearsDay(date) || isLundiDePaques(date);
    }

    private boolean isNewYearsDay(LocalDate date) {
        if (date.getMonth() != Month.JANUARY) {
            return false;
        }

        boolean duringTheWeek = date.getDayOfMonth() == 1 && !HolidayCalendar.isTheWeekend(date);
        boolean onSunday = date.getDayOfWeek() == MONDAY && date.getDayOfMonth() == 2;

        return duringTheWeek || onSunday;
    }

    private boolean isLundiDePaques(LocalDate date) {
        return date.getDayOfMonth() == easterSunday(date.getYear()).plusDays(1).getDayOfMonth();
    }
}
