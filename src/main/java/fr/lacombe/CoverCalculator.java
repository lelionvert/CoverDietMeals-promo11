package fr.lacombe;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class CoverCalculator {

    private List<Participant> participants;
    private Conference conference;

    CoverCalculator(List<Participant> participants) {
        conference = new Conference(DayOfWeek.THURSDAY, DayOfWeek.SUNDAY);
        this.participants = participants;
    }

    String displayResult() {

        StringBuilder result = new StringBuilder();

        Arrays.stream(DayOfWeek.values())
                .filter(conference::isConferenceDay)
                .forEach(dayOfWeek -> {
                    Map<DietType, Integer> coverDetails = coversByDietForGivenDay(dayOfWeek);
                    result.append(dayOfWeek.toString()).append(": ");
                    coverDetails.keySet().forEach(
                            dietType -> result.append(coverDetails.get(dietType))
                                    .append(" ")
                                    .append(dietType)
                                    .append(" | ")
                    );
                    result.append("\n");
                });
        return result.toString();
    }

    int calculateCoversForGivenDayAndDiet(DayOfWeek day, DietType dietType) {
        int nbCover = 0;
        for (Participant participant : this.participants) {
            if (participant.isDietType(dietType))
                nbCover += nbMealsForGivenDay(participant, day);
        }
        return nbCover;
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

    Map<DietType, Integer> coversByDietForGivenDay(DayOfWeek day) {
        Map<DietType, Integer> coversByDiet = new TreeMap<>();
        for (DietType dietType : DietType.values()) {
            coversByDiet.put(dietType, calculateCoversForGivenDayAndDiet(day, dietType));
        }
        return coversByDiet;
    }
}