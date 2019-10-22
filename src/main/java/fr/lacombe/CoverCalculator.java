package fr.lacombe;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class CoverCalculator {

    private List<Participant> participants;

    CoverCalculator(List<Participant> participants) {
        this.participants = participants;
    }

    String displayResult() {

        StringBuilder result = new StringBuilder();
        for (DayOfWeek dayOfWeek: DayOfWeek.values()) {
            if (dayOfWeek.getValue() >= DayOfWeek.THURSDAY.getValue()
            && dayOfWeek.getValue() <= DayOfWeek.SUNDAY.getValue()) {
                result.append(dayOfWeek.toString()).append(": ");
                Map<DietType, Integer> coverDetails = coverDetails(dayOfWeek);
                for (DietType dietType : coverDetails.keySet()) {
                    result.append(coverDetails.get(dietType))
                            .append(" ")
                            .append(dietType)
                            .append(" | ");
                }
                result.append("\n");
            }

        }

        return result.toString();
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

    Map<DietType, Integer> coverDetails(DayOfWeek day) {
        Map<DietType, Integer> coversByDiet = new TreeMap<>();
        for (DietType dietType : DietType.values()) {
            coversByDiet.put(dietType, covers(day, dietType));
        }
        return coversByDiet;
    }

}
