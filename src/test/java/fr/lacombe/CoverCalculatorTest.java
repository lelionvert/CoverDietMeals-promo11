package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.Map;

import static java.util.Arrays.asList;

public class CoverCalculatorTest {

    private static final Participant OMNIVORE_PARTICIPANT = new Participant(DietType.OMNIVORE, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
    private static final Participant PESCATARIAN_PARTICIPANT = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
    private static final Participant VEGAN_PARTICIPANT = new Participant(DietType.VEGAN, DayOfWeek.THURSDAY, DayOfWeek.SUNDAY);
    private static final Participant VEGETARIAN_PARTICIPANT = new Participant(DietType.VEGETARIAN, DayOfWeek.THURSDAY, DayOfWeek.SUNDAY);

    @Test
    public void numbers_of_pescatarians_diet_is_4_for_two_meals_two_participants_two_days() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT));

        // When
        int pescatarianCovers = coverCalculator.covers(DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(4);
    }

    @Test
    public void daily_meal_multiple_diet() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT));

        // When
        int covers = coverCalculator.covers(DayOfWeek.FRIDAY);

        // Then
        Assertions.assertThat(covers).isEqualTo(4);
    }

    @Test
    public void event_total_covers() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT));

        // When
        int covers = coverCalculator.covers();

        // Then
        Assertions.assertThat(covers).isEqualTo(8);
    }

    @Test
    public void covers_on_friday() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }

    @Test
    public void vegetarian_covers_on_friday_return_0() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.VEGETARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void vegetarian_covers_on_friday_return_2() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(Collections.singletonList(VEGETARIAN_PARTICIPANT));

        // When
        int vegetarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.VEGETARIAN);

        // Then
        Assertions.assertThat(vegetarianCovers).isEqualTo(2);
    }

    @Test
    public void vegan_covers_on_saturday_return_2() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(Collections.singletonList(VEGAN_PARTICIPANT));

        // When
        int veganCovers = coverCalculator.covers(DayOfWeek.SATURDAY, DietType.VEGAN);

        // Then
        Assertions.assertThat(veganCovers).isEqualTo(2);
    }

    @Test
    public void cover_map_details() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(
                asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT, VEGAN_PARTICIPANT,
                        VEGETARIAN_PARTICIPANT));

        // When
        Map<DietType, Integer> coverDetails = coverCalculator.coverDetails(DayOfWeek.SATURDAY);

        // Then
        for (DietType dietType : coverDetails.keySet()) {
            Assertions.assertThat(coverDetails.get(dietType)).isEqualTo(2);
        }
    }


    @Test
    public void display_result_return_formatted_string() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(OMNIVORE_PARTICIPANT, PESCATARIAN_PARTICIPANT, VEGAN_PARTICIPANT,
                VEGETARIAN_PARTICIPANT));

        // When
        String pescatarianCovers = coverCalculator.displayResult();

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo("THURSDAY: 0 OMNIVORE | 1 VEGAN | 1 VEGETARIAN | 0 PESCATARIAN | \n" +
                "FRIDAY: 2 OMNIVORE | 2 VEGAN | 2 VEGETARIAN | 2 PESCATARIAN | \n" +
                "SATURDAY: 2 OMNIVORE | 2 VEGAN | 2 VEGETARIAN | 2 PESCATARIAN | \n" +
                "SUNDAY: 0 OMNIVORE | 1 VEGAN | 1 VEGETARIAN | 0 PESCATARIAN | \n");
    }
}