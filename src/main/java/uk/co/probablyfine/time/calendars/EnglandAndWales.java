package uk.co.probablyfine.time.calendars;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

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

    private LocalDate easterSunday(int year) {
        return Stream.of(
                        LocalDate.of(2000, 4, 23),
                        LocalDate.of(2001, 4, 15),
                        LocalDate.of(2002, 3, 31),
                        LocalDate.of(2003, 4, 20),
                        LocalDate.of(2004, 4, 11),
                        LocalDate.of(2005, 3, 27),
                        LocalDate.of(2006, 4, 16),
                        LocalDate.of(2007, 4, 8),
                        LocalDate.of(2008, 3, 23),
                        LocalDate.of(2009, 4, 12),
                        LocalDate.of(2010, 4, 4),
                        LocalDate.of(2011, 4, 24),
                        LocalDate.of(2012, 4, 8),
                        LocalDate.of(2013, 3, 31),
                        LocalDate.of(2014, 4, 20),
                        LocalDate.of(2015, 4, 5),
                        LocalDate.of(2016, 3, 27),
                        LocalDate.of(2017, 4, 16),
                        LocalDate.of(2018, 4, 1),
                        LocalDate.of(2019, 4, 21),
                        LocalDate.of(2020, 4, 12),
                        LocalDate.of(2021, 4, 4),
                        LocalDate.of(2022, 4, 17),
                        LocalDate.of(2023, 4, 9),
                        LocalDate.of(2024, 3, 31),
                        LocalDate.of(2025, 4, 20),
                        LocalDate.of(2026, 4, 5),
                        LocalDate.of(2027, 3, 28),
                        LocalDate.of(2028, 4, 16),
                        LocalDate.of(2029, 4, 1),
                        LocalDate.of(2030, 4, 21),
                        LocalDate.of(2031, 4, 13),
                        LocalDate.of(2032, 3, 28),
                        LocalDate.of(2033, 4, 17),
                        LocalDate.of(2034, 4, 9),
                        LocalDate.of(2035, 3, 25),
                        LocalDate.of(2036, 4, 13),
                        LocalDate.of(2037, 4, 5),
                        LocalDate.of(2038, 4, 25),
                        LocalDate.of(2039, 4, 10),
                        LocalDate.of(2040, 4, 1),
                        LocalDate.of(2041, 4, 21),
                        LocalDate.of(2042, 4, 6),
                        LocalDate.of(2043, 3, 29),
                        LocalDate.of(2044, 4, 17),
                        LocalDate.of(2045, 4, 9),
                        LocalDate.of(2046, 3, 25),
                        LocalDate.of(2047, 4, 14),
                        LocalDate.of(2048, 4, 5),
                        LocalDate.of(2049, 4, 18),
                        LocalDate.of(2050, 4, 10),
                        LocalDate.of(2051, 4, 2),
                        LocalDate.of(2052, 4, 21),
                        LocalDate.of(2053, 4, 6),
                        LocalDate.of(2054, 3, 29),
                        LocalDate.of(2055, 4, 18),
                        LocalDate.of(2056, 4, 2),
                        LocalDate.of(2057, 4, 22),
                        LocalDate.of(2058, 4, 14),
                        LocalDate.of(2059, 3, 30),
                        LocalDate.of(2060, 4, 18),
                        LocalDate.of(2061, 4, 10),
                        LocalDate.of(2062, 3, 26),
                        LocalDate.of(2063, 4, 15),
                        LocalDate.of(2064, 4, 6),
                        LocalDate.of(2065, 3, 29),
                        LocalDate.of(2066, 4, 11),
                        LocalDate.of(2067, 4, 3),
                        LocalDate.of(2068, 4, 22),
                        LocalDate.of(2069, 4, 14),
                        LocalDate.of(2070, 3, 30),
                        LocalDate.of(2071, 4, 19),
                        LocalDate.of(2072, 4, 10),
                        LocalDate.of(2073, 3, 26),
                        LocalDate.of(2074, 4, 15),
                        LocalDate.of(2075, 4, 7),
                        LocalDate.of(2076, 4, 19),
                        LocalDate.of(2077, 4, 11),
                        LocalDate.of(2078, 4, 3),
                        LocalDate.of(2079, 4, 23),
                        LocalDate.of(2080, 4, 7),
                        LocalDate.of(2081, 3, 30),
                        LocalDate.of(2082, 4, 19),
                        LocalDate.of(2083, 4, 4),
                        LocalDate.of(2084, 3, 26),
                        LocalDate.of(2085, 4, 15),
                        LocalDate.of(2086, 3, 31),
                        LocalDate.of(2087, 4, 20),
                        LocalDate.of(2088, 4, 11),
                        LocalDate.of(2089, 4, 3),
                        LocalDate.of(2090, 4, 16),
                        LocalDate.of(2091, 4, 8),
                        LocalDate.of(2092, 3, 30),
                        LocalDate.of(2093, 4, 12),
                        LocalDate.of(2094, 4, 4),
                        LocalDate.of(2095, 4, 24),
                        LocalDate.of(2096, 4, 15),
                        LocalDate.of(2097, 3, 31),
                        LocalDate.of(2098, 4, 20),
                        LocalDate.of(2099, 4, 12))
                .filter(easterSunday -> easterSunday.getYear() == year)
                .findFirst()
                .orElseThrow();
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
