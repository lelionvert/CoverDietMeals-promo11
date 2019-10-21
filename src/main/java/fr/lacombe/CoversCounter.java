package fr.lacombe;

import java.time.DayOfWeek;

class CoversCounter {

    private static final String PESCATARIAN = "Pescatarian";

    int getPescatarianCovers(Participant participant) {
        if (PESCATARIAN.equals(participant.getDiet())) {
            if (DayOfWeek.FRIDAY.equals(participant.getDay())) {
                return 2;
            }
            return 1;
        }
        return 0;
    }
}
