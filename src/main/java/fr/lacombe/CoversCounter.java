package fr.lacombe;

public class CoversCounter {
    public int getPescatarianCovers(Participant participant) {
        if (participant.getDiet().equals("Normal")) return 0;
        return 1;
    }
}
