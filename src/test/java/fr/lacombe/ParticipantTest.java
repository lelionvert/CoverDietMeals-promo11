package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.DayOfWeek;

public class ParticipantTest {

    @Test
    public void nb_meals_is_four_when_participant_comes_friday_and_leaves_saturday() {
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        Assertions.assertThat(participant.calculateNbMeals()).isEqualTo(4);
    }

    @Test
    public void nb_meals_is_two_when_participant_comes_and_leaves_friday() {
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.FRIDAY, DayOfWeek.FRIDAY);
        Assertions.assertThat(participant.calculateNbMeals()).isEqualTo(2);
    }

    @Test
    public void nb_meals_is_two_when_participant_comes_and_leaves_saturday() {
        Participant participant = new Participant(DietType.NORMAL, DayOfWeek.SATURDAY, DayOfWeek.SATURDAY);
        Assertions.assertThat(participant.calculateNbMeals()).isEqualTo(2);
    }

}