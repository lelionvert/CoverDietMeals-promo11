package fr.lacombe;

class CoversCounter {

    private static final String PESCATARIAN = "Pescatarian";

    int getPescatarianCovers(Participant participant) {
        if ("Friday".equals(participant.getDay())) {
            return 2;
        }
        if (PESCATARIAN.equals(participant.getDiet())) {
            return 1;
        }
        return 0;
    }
}
