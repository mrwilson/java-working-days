package uk.co.probablyfine.time.calendars;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class UnitedStates implements HolidayCalendar {
    @Override
    public boolean isPublicHoliday(LocalDate date) {
        boolean mlkJrDay =
                date.getMonth() == Month.JANUARY
                        && date.getDayOfWeek() == DayOfWeek.MONDAY
                        && date.getDayOfMonth() >= 15
                        && date.getDayOfMonth() <= 21;

        boolean presidentsDay =
                date.getMonth() == Month.FEBRUARY
                        && date.getDayOfWeek() == DayOfWeek.MONDAY
                        && date.getDayOfMonth() >= 15
                        && date.getDayOfMonth() <= 21;

        return mlkJrDay || presidentsDay;
    }
}
