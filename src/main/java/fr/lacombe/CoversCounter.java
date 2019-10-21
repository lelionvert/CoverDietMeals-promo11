package fr.lacombe;

import java.time.DayOfWeek;
import java.util.List;

class CoversCounter {

    private List<Participant> participants;

    public CoversCounter(List<Participant> participants) {
        this.participants = participants;
    }

    public String getResult() {
        return "";
    }

    public int getPescatarianCovers() {
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
