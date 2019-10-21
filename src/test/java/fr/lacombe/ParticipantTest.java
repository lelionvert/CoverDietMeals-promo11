package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ParticipantTest {

    @Test
    public void get_correct_diet_for_participant() {
        Participant participant = new Participant("Pescatarian");

        Assertions.assertThat(participant.getDiet()).isEqualTo("Pescatarian");
    }
}