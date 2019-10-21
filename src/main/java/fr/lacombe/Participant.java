package fr.lacombe;

import java.time.DayOfWeek;

class Participant {
    private String diet;
    private DayOfWeek day;

    Participant(String diet, DayOfWeek day) {
        this.diet = diet;
        this.day = day;
    }

    DayOfWeek getDay() {
        return day;
    }

    String getDiet() {
        return diet;
    }
}
