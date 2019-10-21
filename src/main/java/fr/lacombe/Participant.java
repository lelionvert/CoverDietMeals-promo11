package fr.lacombe;

import java.time.DayOfWeek;

class Participant {
    private DietType diet;
    private DayOfWeek day;

    Participant(DietType diet, DayOfWeek day) {
        this.diet = diet;
        this.day = day;
    }

    DayOfWeek getDay() {
        return day;
    }

    boolean isPescatarian() {
        return diet.equals(DietType.PESCATARIAN);
    }
}
