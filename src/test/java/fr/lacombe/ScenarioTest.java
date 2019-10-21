package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ScenarioTest {

    @Test
    public void number_of_pescatarian_covers_is_two_for_one_pescatarian_participant_one_day() {
        // Given
        Participant bruno = new Participant("Pescatarian", "Friday");
        CoversCounter coversCounter = new CoversCounter();

        // When
        int pescatarianCovers = coversCounter.getPescatarianCovers(bruno);

        // Then
        Assertions.assertThat(pescatarianCovers).isEqualTo(2);
    }
}
