package fr.lacombe;

import java.time.DayOfWeek;
import java.util.List;

class CoversCounter {

    public CoversCounter(List<Participant> participants) {

    }

    public CoversCounter() {

    }

    int getPescatarianCovers(List<Participant> participants) {
        int nbPescatarian = 0;
        for (Participant participant : participants) {
            if (participant.isPescatarian()) {
                if(DayOfWeek.SATURDAY.equals(participant.getDepartureDay())){
                    nbPescatarian += 2;
                }
                if (DayOfWeek.FRIDAY.equals(participant.getDay())) {
                    nbPescatarian += 2;
                } else {
                    nbPescatarian += 1;
                }
            }
        }
        return nbPescatarian;
    }

    public String getResult() {
        return "";
    }
}
