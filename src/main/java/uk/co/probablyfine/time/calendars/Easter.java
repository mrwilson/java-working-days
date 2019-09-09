package uk.co.probablyfine.time.calendars;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface Easter {

    List<LocalDate> EASTER_SUNDAYS =
            Arrays.asList(
                    LocalDate.of(1900, 4, 15),
                    LocalDate.of(1925, 4, 12),
                    LocalDate.of(1950, 4, 9),
                    LocalDate.of(1975, 3, 30),
                    LocalDate.of(1901, 4, 7),
                    LocalDate.of(1926, 4, 4),
                    LocalDate.of(1951, 3, 25),
                    LocalDate.of(1976, 4, 18),
                    LocalDate.of(1902, 3, 30),
                    LocalDate.of(1927, 4, 17),
                    LocalDate.of(1952, 4, 13),
                    LocalDate.of(1977, 4, 10),
                    LocalDate.of(1903, 4, 12),
                    LocalDate.of(1928, 4, 8),
                    LocalDate.of(1953, 4, 5),
                    LocalDate.of(1978, 3, 26),
                    LocalDate.of(1904, 4, 3),
                    LocalDate.of(1929, 3, 31),
                    LocalDate.of(1954, 4, 18),
                    LocalDate.of(1979, 4, 15),
                    LocalDate.of(1905, 4, 23),
                    LocalDate.of(1930, 4, 20),
                    LocalDate.of(1955, 4, 10),
                    LocalDate.of(1980, 4, 6),
                    LocalDate.of(1906, 4, 15),
                    LocalDate.of(1931, 4, 5),
                    LocalDate.of(1956, 4, 1),
                    LocalDate.of(1981, 4, 19),
                    LocalDate.of(1907, 3, 31),
                    LocalDate.of(1932, 3, 27),
                    LocalDate.of(1957, 4, 21),
                    LocalDate.of(1982, 4, 11),
                    LocalDate.of(1908, 4, 19),
                    LocalDate.of(1933, 4, 16),
                    LocalDate.of(1958, 4, 6),
                    LocalDate.of(1983, 4, 3),
                    LocalDate.of(1909, 4, 11),
                    LocalDate.of(1934, 4, 1),
                    LocalDate.of(1959, 3, 29),
                    LocalDate.of(1984, 4, 22),
                    LocalDate.of(1910, 3, 27),
                    LocalDate.of(1935, 4, 21),
                    LocalDate.of(1960, 4, 17),
                    LocalDate.of(1985, 4, 7),
                    LocalDate.of(1911, 4, 16),
                    LocalDate.of(1936, 4, 12),
                    LocalDate.of(1961, 4, 2),
                    LocalDate.of(1986, 3, 30),
                    LocalDate.of(1912, 4, 7),
                    LocalDate.of(1937, 3, 28),
                    LocalDate.of(1962, 4, 22),
                    LocalDate.of(1987, 4, 19),
                    LocalDate.of(1913, 3, 23),
                    LocalDate.of(1938, 4, 17),
                    LocalDate.of(1963, 4, 14),
                    LocalDate.of(1988, 4, 3),
                    LocalDate.of(1914, 4, 12),
                    LocalDate.of(1939, 4, 9),
                    LocalDate.of(1964, 3, 29),
                    LocalDate.of(1989, 3, 26),
                    LocalDate.of(1915, 4, 4),
                    LocalDate.of(1940, 3, 24),
                    LocalDate.of(1965, 4, 18),
                    LocalDate.of(1990, 4, 15),
                    LocalDate.of(1916, 4, 23),
                    LocalDate.of(1941, 4, 13),
                    LocalDate.of(1966, 4, 10),
                    LocalDate.of(1991, 3, 31),
                    LocalDate.of(1917, 4, 8),
                    LocalDate.of(1942, 4, 5),
                    LocalDate.of(1967, 3, 26),
                    LocalDate.of(1992, 4, 19),
                    LocalDate.of(1918, 3, 31),
                    LocalDate.of(1943, 4, 25),
                    LocalDate.of(1968, 4, 14),
                    LocalDate.of(1993, 4, 11),
                    LocalDate.of(1919, 4, 20),
                    LocalDate.of(1944, 4, 9),
                    LocalDate.of(1969, 4, 6),
                    LocalDate.of(1994, 4, 3),
                    LocalDate.of(1920, 4, 4),
                    LocalDate.of(1945, 4, 1),
                    LocalDate.of(1970, 3, 29),
                    LocalDate.of(1995, 4, 16),
                    LocalDate.of(1921, 3, 27),
                    LocalDate.of(1946, 4, 21),
                    LocalDate.of(1971, 4, 11),
                    LocalDate.of(1996, 4, 7),
                    LocalDate.of(1922, 4, 16),
                    LocalDate.of(1947, 4, 6),
                    LocalDate.of(1972, 4, 2),
                    LocalDate.of(1997, 3, 30),
                    LocalDate.of(1923, 4, 1),
                    LocalDate.of(1948, 3, 28),
                    LocalDate.of(1973, 4, 22),
                    LocalDate.of(1998, 4, 12),
                    LocalDate.of(1924, 4, 20),
                    LocalDate.of(1949, 4, 17),
                    LocalDate.of(1974, 4, 14),
                    LocalDate.of(1999, 4, 4),
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
                    LocalDate.of(2099, 4, 12));

    static LocalDate easterSunday(int year) {
        return EASTER_SUNDAYS.stream()
                .filter(easterSunday -> easterSunday.getYear() == year)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
