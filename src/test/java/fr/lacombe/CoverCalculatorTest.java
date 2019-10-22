package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Collections;

import static java.util.Arrays.asList;

public class CoverCalculatorTest {


    private static final Participant BRUNO = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
    private static final Participant SOPHIA = new Participant(DietType.PESCATARIAN, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

    @Test
    public void numbers_of_pescatarians_diet_is_4_for_two_meals_two_participants_two_days() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(BRUNO, SOPHIA));

        // When
        int pescatarianCovers = coverCalculator.covers(DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(4);
    }

    @Test
    public void daily_meal_multiple_diet() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(BRUNO, SOPHIA));

        // When
        int covers = coverCalculator.covers(DayOfWeek.FRIDAY);

        // Then
        Assertions.assertThat(covers).isEqualTo(4);
    }

    @Test
    public void event_total_covers() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(BRUNO, SOPHIA));

        // When
        int covers = coverCalculator.covers();

        // Then
        Assertions.assertThat(covers).isEqualTo(8);
    }

    @Test
    public void covers_on_friday() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(BRUNO,SOPHIA));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.PESCATARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }

    @Test
    public void vegetarian_covers_on_friday_return_0() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(BRUNO, SOPHIA));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.VEGETARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

    @Test
    public void vegetarian_covers_on_friday_return_string() {
        // Given
        CoverCalculator coverCalculator = new CoverCalculator(asList(BRUNO, SOPHIA));

        // When
        int pescatarianCovers = coverCalculator.covers(DayOfWeek.FRIDAY, DietType.VEGETARIAN);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(0);
    }

}