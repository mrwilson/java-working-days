# java-working-days

> What date is N working days after date X?

**Under Development - [Caveat Emptor](https://en.wikipedia.org/wiki/Caveat_emptor)**

## Examples

```java
WorkingDays workingDays = new WorkingDays();

workingDays.after(LocalDate.of(2019, 1, 1), 10);
// LocalDate[2019, 1, 16]

workingDays.isPublicHoliday(LocalDate.of(2020, 5, 8))
// true (75th anniversary of VE Day)
```