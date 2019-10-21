package fr.lacombe;

import java.time.DayOfWeek;

public class Booking {
    DayOfWeek arrivalDay;
    DayOfWeek departureDay;

    public Booking(DayOfWeek arrivalDay, DayOfWeek departureDay) {
        this.arrivalDay = arrivalDay;
        this.departureDay = departureDay;
    }

    int calculateNbMeals() {
        int nbMeals = calculateStayDuration() * 2;

        if (arrivesFirstDay()) {
            nbMeals--;
        }
        if (leavesLastDay()) {
            nbMeals--;
        }
        return nbMeals;
    }

    boolean leavesLastDay() {
        return departureDay == DayOfWeek.SUNDAY;
    }

    boolean arrivesFirstDay() {
        return arrivalDay == DayOfWeek.THURSDAY;
    }

    int calculateStayDuration() {
        return departureDay.getValue() - arrivalDay.getValue() + 1;
    }
}