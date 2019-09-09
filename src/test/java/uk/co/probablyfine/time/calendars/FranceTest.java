package uk.co.probablyfine.time.calendars;

import static uk.co.probablyfine.time.calendars.HolidayCalendar.FRANCE;

import org.junit.Test;
import uk.co.probablyfine.time.WorkingDays;
import uk.co.probablyfine.time.WorkingDaysTest;

public class FranceTest implements WorkingDaysTest {

    private final WorkingDays workingDays = WorkingDays.usingCalendar(FRANCE);

    @Override
    public WorkingDays objectUnderTest() {
        return this.workingDays;
    }

    @Test
    public void shouldHandleJourDeLan() {
        // Jour de l'an was observed on 1st January in 2019
        assertWorkingDaysRelationship(date(2018, 12, 31), 1, date(2019, 1, 2));

        // Jour de l'an has no Public Holiday in 2022
        assertWorkingDaysRelationship(date(2021, 12, 31), 1, date(2022, 1, 3));

        // Jour de l'an is observed on 2nd January in 2023
        assertWorkingDaysRelationship(date(2022, 12, 30), 1, date(2023, 1, 3));
    }

    @Test
    public void shouldHandleLundiDePaques() {
        // Lundi de Pâques was observed on 1st January in 2019
        assertWorkingDaysRelationship(date(2019, 4, 19), 1, date(2019, 4, 23));

        // Lundi de Pâques has no Public Holiday in 2022
        assertWorkingDaysRelationship(date(2020, 4, 10), 1, date(2020, 4, 14));

        // Lundi de Pâques is observed on 2nd January in 2023
        assertWorkingDaysRelationship(date(2021, 4, 2), 1, date(2021, 4, 6));
    }
}
