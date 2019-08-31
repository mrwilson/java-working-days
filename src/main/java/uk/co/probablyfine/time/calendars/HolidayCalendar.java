package uk.co.probablyfine.time.calendars;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.LocalDate;

public interface HolidayCalendar {

    HolidayCalendar ENGLAND_AND_WALES = new EnglandAndWales();
    HolidayCalendar UNITED_STATES = new UnitedStates();

    boolean isPublicHoliday(LocalDate date);

    static boolean isTheWeekend(LocalDate date) {
        return date.getDayOfWeek() == SATURDAY || date.getDayOfWeek() == SUNDAY;
    }
}
