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
        int i = 0;
        for (Participant participant : participants) {
            if (participant.getDiet().equals(DietType.PESCATARIAN)) {

                i += 2;
            }
        }
        return i;
    }
}
