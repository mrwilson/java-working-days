package uk.co.probablyfine.time.calendars;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class UnitedStates implements HolidayCalendar {
    @Override
    public boolean isPublicHoliday(LocalDate date) {
        return date.getMonth() == Month.JANUARY
                && date.getDayOfWeek() == DayOfWeek.MONDAY
                && date.getDayOfMonth() >= 15
                && date.getDayOfMonth() <= 21;
    }
}