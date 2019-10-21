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

    boolean isPescatarian() {
        return diet.equals(DietType.PESCATARIAN);
    }

    int calculateNbMeals() {
        int nbMeals = (departureDay.getValue() - arrivalDay.getValue() + 1) * 2;

        if(arrivalDay == DayOfWeek.THURSDAY) {
            nbMeals --;
        }
        if(departureDay == DayOfWeek.SUNDAY) {
            nbMeals --;
        }
        return nbMeals;
    }
}
