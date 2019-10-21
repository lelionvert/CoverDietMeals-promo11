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
        Participant bruno = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(Collections.singletonList(bruno));

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }


    @Test
    public void number_of_pescatarian_covers_is_two_for_two_participants_one_normal_one_pescatarian_one_day() {
        // Given
        Participant bruno = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY);
        Participant norman = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(asList(bruno, norman));

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }
}
