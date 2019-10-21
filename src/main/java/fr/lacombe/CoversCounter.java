package fr.lacombe;

public class CoversCounter {
    public int getPescatarianCovers(Participant participant) {

        if ("Friday".equals(participant.getDay())) return 2;
        if ("Normal".equals(participant.getDiet())) return 0;
        return 1;
    }
}
