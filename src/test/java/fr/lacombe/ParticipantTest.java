package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.DayOfWeek;

public class ParticipantTest {

    @Test
    public void calculateNbMeals() {
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        Assertions.assertThat(participant.calculateNbMeals()).isEqualTo(4);
    }
}