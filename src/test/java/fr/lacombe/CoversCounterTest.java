package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Collections;

import static java.util.Arrays.asList;

public class CoversCounterTest {

    @Test
    public void numbers_of_pescatarians_diet_is_1_for_one_meal_one_participant() {
        // Given
        Participant participant = new Participant(DietType.PESCATARIAN, DayOfWeek.THURSDAY,DayOfWeek.THURSDAY);
        CoversCounter coversCounter = new CoversCounter(Collections.singletonList(participant));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(1);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_0_for_one_meal_one_normal_diet_participant() {
        // Given
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.THURSDAY, DayOfWeek.THURSDAY);
        CoversCounter coversCounter = new CoversCounter(Collections.singletonList(participant));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_0_for_two_meal_one_participant() {
        // Given
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter(Collections.singletonList(participant));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_0_for_two_meal_two_participants() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        Participant participant2 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter(asList(participant1, participant2));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_2_for_two_meals_two_participants() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        Participant participant2 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY,DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter(asList(participant1, participant2));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_4_for_two_meals_three_participants() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        Participant participant2 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        Participant participant3 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        CoversCounter coversCounter = new CoversCounter(asList(participant1, participant2, participant3));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(4);
    }

    @Test
    public void numbers_of_pescatarians_diet_is_4_for_two_meals_two_participants_two_days() {
        // Given
        Participant participant1 = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        Participant participant2 = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        CoversCounter coversCounter = new CoversCounter(asList(participant1, participant2));

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(4);
    }

}