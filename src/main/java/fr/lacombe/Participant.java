package fr.lacombe;

import java.time.DayOfWeek;

class Participant {
    private DietType diet;
    private DayOfWeek day;
    private DayOfWeek departureDay;

    Participant(DietType diet, DayOfWeek day) {
        this.diet = diet;
        this.day = day;
    }

    public Participant(DietType diet, DayOfWeek arrivalDay, DayOfWeek departureDay) {
        this.diet = diet;
        day = arrivalDay;
        this.departureDay = departureDay;
    }

    DayOfWeek getDay() {
        return day;
    }

    boolean isPescatarian() {
        return diet.equals(DietType.PESCATARIAN);
    }

    public DayOfWeek getDepartureDay() {
        return departureDay;
    }
}
