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
                nbPescatarian += participant.calculateNbMeals();
            }
        }
        return nbPescatarian;
    }


}
