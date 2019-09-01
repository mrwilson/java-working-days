# java-working-days

[![Build Status](https://travis-ci.org/mrwilson/java-working-days.svg?branch=master)](https://travis-ci.org/mrwilson/java-working-days)

> What date is N working days after date X?

**Under Development - [Caveat Emptor](https://en.wikipedia.org/wiki/Caveat_emptor)**

## Examples

The `java-working-days` library exposes three methods as partial inverses to each-other.

```java
import static uk.co.probablyfine.time.calendars.HolidayCalendar.ENGLAND_AND_WALES;

WorkingDays workingDays = WorkingDays.usingCalendar(ENGLAND_AND_WALES);

workingDays.daysAfter(LocalDate.of(2019, 1, 1), 10);
// LocalDate[2019, 1, 16]

workingDays.daysBefore(LocalDate.of(2019, 1, 16), 10)
// LocalDate[2019, 1, 1]

workingDays.daysBetween(LocalDate.of(2019, 1, 16), LocalDate.of(2019, 1, 1))
// 10
```

## Supported Calendars

- [x] 🏴󠁧󠁢󠁥󠁮󠁧󠁿🏴󠁧󠁢󠁷󠁬󠁳󠁿 England & Wales 
- [x] 🇺🇸 United States
- [ ] 🏴󠁧󠁢󠁳󠁣󠁴󠁿 Scotland
- [ ] 🇬🇧 Northern Ireland
- [ ] 🇫🇷 France