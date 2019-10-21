package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CoversCounterTest {
    @Test
    public void numbers_of_pescatarians_diet_is_1_for_one_meal_one_participant() {
        // Given
        Participant participant = new Participant("Pescatarian");
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(participant);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(1);
    }
}