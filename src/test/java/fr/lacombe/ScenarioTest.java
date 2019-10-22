package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Collections;

import static java.util.Arrays.asList;

public class ScenarioTest {

    @Test
    public void number_of_pescatarian_covers_is_two_for_one_pescatarian_participant_one_day() {
        // Given
        Participant bruno = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        CoverCalculator coverCalculator = new CoverCalculator(Collections.singletonList(bruno));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }


    @Test
    public void number_of_pescatarian_covers_is_two_for_two_participants_one_normal_one_pescatarian_one_day() {
        // Given
        Participant bruno = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        Participant norman = new Participant(DietType.OMNIVORE, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        CoverCalculator coverCalculator = new CoverCalculator(asList(bruno, norman));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }

    @Test
    @Ignore
    public void number_of_pescatarian_covers_is_two_for_two_participants_one_normal_one_pescatarian_two_days() {
        // Given
        Participant bruno = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        Participant norman = new Participant(DietType.OMNIVORE, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        CoverCalculator coverCalculator = new CoverCalculator(asList(bruno, norman));

        // When
        String pescatarianCovers = coverCalculator.getResult();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo("2 covers, p, Friday \n 2 covers, p, Saturday");
    }
}
