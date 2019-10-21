package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Arrays;

public class CoversCounterTest {

    @Test
    public void numbers_of_pescatarians_diet_is_1_for_one_meal_one_participant() {
        // Given
        Participant participant = new Participant(DietType.PESCATARIAN, DayOfWeek.THURSDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(participant);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(1);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_0_for_one_meal_one_normal_diet_participant() {
        // Given
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.THURSDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(participant);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_0_for_two_meal_one_participant() {
        // Given
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(participant);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_0_for_two_meal_two_participants() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY);
        Participant participant2 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(Arrays.asList(participant1, participant2));

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_2_for_two_meals_two_participants() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY);
        Participant participant2 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(Arrays.asList(participant1, participant2));

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_4_for_two_meals_three_participants() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY);
        Participant participant2 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY);
        Participant participant3 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(Arrays.asList(participant1, participant2, participant3));

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(4);
    }


}