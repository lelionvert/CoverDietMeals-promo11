package fr.lacombe;

import java.time.DayOfWeek;

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
}
