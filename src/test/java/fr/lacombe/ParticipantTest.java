package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParticipantTest {

    @Test
    public void get_correct_diet_for_participant() {
        Participant participant = new Participant("Pescatarian", "Friday");

        Assertions.assertThat(participant.getDiet()).isEqualTo("Pescatarian");
    }
}