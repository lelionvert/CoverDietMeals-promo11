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

    int calculateCovers() {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            nbCover += calculateNbMeals(participant);
        }
        return nbCover;
    }

    int calculateCovers(DayOfWeek day) {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            nbCover += calculateDailyNbMeals(participant, day);
        }
        return nbCover;
    }

    private int calculateNbMeals(Participant participant) {
        int nbMeals = participant.getStayDuration() * 2;

        if (participant.arrivesFirstDay()) {
            nbMeals--;
        }
        if (participant.leavesLastDay()) {
            nbMeals--;
        }
        return nbMeals;
    }

    private int calculateDailyNbMeals(Participant participant, DayOfWeek dayOfWeek) {
        int nbMeals = 0;
        if (participant.isPresent(dayOfWeek)) {
            nbMeals = 2;

            if (participant.arrivesFirstDay()) {
                nbMeals--;
            }
            if (participant.leavesLastDay()) {
                nbMeals--;
            }
        }
        return nbMeals;
    }

    int calculatePescatarianCovers() {
        int nbPescatarian = 0;
        for (Participant participant : this.participants) {
            if (participant.isPescatarian()) {
                nbPescatarian += calculateNbMeals(participant);
            }
        }
        return nbPescatarian;
    }

    int calculateCovers(DayOfWeek day, DietType dietType) {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            if(participant.isDietType(dietType))
            nbCover += calculateDailyNbMeals(participant, day);
        }
        return nbCover;
    }
}
