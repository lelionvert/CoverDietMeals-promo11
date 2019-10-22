package fr.lacombe;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

class CoverCalculator {

    private List<Participant> participants;

    CoverCalculator(List<Participant> participants) {
        this.participants = participants;
    }

    String getResult() {
        return "";
    }

    int covers() {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            nbCover += nbMeals(participant);
        }
        return nbCover;
    }

    int covers(DayOfWeek day) {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            nbCover += nbMealsForGivenDay(participant, day);
        }
        return nbCover;
    }

    int covers(DietType dietType) {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            if(participant.isDietType(dietType))
                nbCover += nbMeals(participant);
        }
        return nbCover;
    }

    int covers(DayOfWeek day, DietType dietType) {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            if(participant.isDietType(dietType))
                nbCover += nbMealsForGivenDay(participant, day);
        }
        return nbCover;
    }

    private int nbMeals(Participant participant) {
        int nbMeals = participant.getStayDuration() * 2;

        if (participant.arrivesFirstDay()) {
            nbMeals--;
        }
        if (participant.leavesLastDay()) {
            nbMeals--;
        }
        return nbMeals;
    }

    private int nbMealsForGivenDay(Participant participant, DayOfWeek dayOfWeek) {
        if (participant.isPresent(dayOfWeek)) {
            if (DayOfWeek.THURSDAY == dayOfWeek || DayOfWeek.SUNDAY == dayOfWeek) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    int pescatarianCovers() {
        int nbPescatarian = 0;
        for (Participant participant : this.participants) {
            if (participant.isPescatarian()) {
                nbPescatarian += nbMeals(participant);
            }
        }
        return nbPescatarian;
    }

    Map<DietType, Integer> coverDetails() {
        return null;
    }
}
