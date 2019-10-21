package fr.lacombe;

import java.time.DayOfWeek;
import java.util.List;

class CoversCounter {

    int getPescatarianCovers(Participant participant) {
        if (DietType.PESCATARIAN.equals(participant.getDiet())) {
            if (DayOfWeek.FRIDAY.equals(participant.getDay())) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    int getPescatarianCovers(List<Participant> participants) {
        if (participants.get(1).getDiet().equals(DietType.PESCATARIAN)) {
            return 2;
        }
        return 0;
    }
}
