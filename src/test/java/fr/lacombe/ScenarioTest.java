package fr.lacombe;

import org.assertj.core.api.Assertions;
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
        int pescatarianCovers = coverCalculator.calculateCoversForGivenDayAndDiet(DayOfWeek.FRIDAY, DietType.PESCATARIAN);

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
        int pescatarianCovers = coverCalculator.calculateCoversForGivenDayAndDiet(DayOfWeek.FRIDAY, DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }

    @Test
    public void display_result_return_formatted_string() {
        // Given
        Participant omnivoreParticipant = new Participant(DietType.OMNIVORE, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY);
        Participant vegetarianParticipant1 = new Participant(DietType.VEGETARIAN, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        Participant veganParticipant = new Participant(DietType.VEGAN, DayOfWeek.THURSDAY, DayOfWeek.SUNDAY);
        Participant vegetarianParticipant2 = new Participant(DietType.VEGETARIAN, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY);

        CoverCalculator coverCalculator = new CoverCalculator(asList(omnivoreParticipant, vegetarianParticipant1, veganParticipant,
                vegetarianParticipant2));

        // When
        String pescatarianCovers = coverCalculator.displayResult();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo("THURSDAY: 0 OMNIVORE | 1 VEGAN | 0 VEGETARIAN | 0 PESCATARIAN | \n" +
                "FRIDAY: 2 OMNIVORE | 2 VEGAN | 4 VEGETARIAN | 0 PESCATARIAN | \n" +
                "SATURDAY: 2 OMNIVORE | 2 VEGAN | 4 VEGETARIAN | 0 PESCATARIAN | \n" +
                "SUNDAY: 1 OMNIVORE | 1 VEGAN | 1 VEGETARIAN | 0 PESCATARIAN | \n");
    }
}
