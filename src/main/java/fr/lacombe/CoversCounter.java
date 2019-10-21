package fr.lacombe;

import java.time.DayOfWeek;
import java.util.List;

class CoversCounter {

    private List<Participant> participants;

    CoversCounter(List<Participant> participants) {
        this.participants = participants;
    }

    String getResult() {
        return "";
    }

    int getPescatarianCovers() {
        int nbPescatarian = 0;
        for (Participant participant : this.participants) {
            if (participant.isPescatarian()) {
                if(DayOfWeek.SATURDAY.equals(participant.getDepartureDay())){
                    nbPescatarian += 2;
                }
                if (DayOfWeek.FRIDAY.equals(participant.getArrivalDay())) {
                    nbPescatarian += 2;
                } else {
                    nbPescatarian += 1;
                }
            }
        }
        return nbPescatarian;
    }


}
