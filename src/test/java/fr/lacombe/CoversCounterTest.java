package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoversCounterTest {
    @Test
    public void numbers_of_pescatarians_diet_is_1_for_one_meal_one_participant() {
        Participant participant = new Participant("Pescatarian","Friday");
        CoversCounter coversCounter = new CoversCounter();

        Assertions.assertThat(coversCounter.getPescatarianCovers(participant)).isEqualTo(1);
    }
}