package fr.lacombe;

import java.time.DayOfWeek;

class Participant {
    private DietType diet;
    private DayOfWeek arrivalDay;
    private DayOfWeek departureDay;

    Participant(DietType diet, DayOfWeek arrivalDay) {
        this.diet = diet;
        this.arrivalDay = arrivalDay;
    }

    Participant(DietType diet, DayOfWeek arrivalDay, DayOfWeek departureDay) {
        this.diet = diet;
        this.arrivalDay = arrivalDay;
        this.departureDay = departureDay;
    }

    DayOfWeek getArrivalDay() {
        return arrivalDay;
    }

    boolean isPescatarian() {
        return diet.equals(DietType.PESCATARIAN);
    }

    DayOfWeek getDepartureDay() {
        return departureDay;
    }

    int calculateNbMeals() {
        if (departureDay == DayOfWeek.FRIDAY || arrivalDay == DayOfWeek.SATURDAY) {
            return 2;
        }
        return 4;
    }
}
