package fr.lacombe;

import java.time.DayOfWeek;
import java.util.List;

class CoversCounter {

    int getPescatarianCovers(List<Participant> participants) {
        int nbPescatarian = 0;
        for (Participant participant : participants) {
            if (participant.getDiet().equals(DietType.PESCATARIAN)) {
                if (DayOfWeek.FRIDAY.equals(participant.getDay())) {
                    nbPescatarian += 2;
                } else {
                    nbPescatarian += 1;
                }
            }
        }
        return nbPescatarian;
    }
}
