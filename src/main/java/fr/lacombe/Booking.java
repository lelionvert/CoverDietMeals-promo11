package fr.lacombe;

import java.time.DayOfWeek;

class Booking {
    private DayOfWeek arrivalDay;
    private DayOfWeek departureDay;

    Booking(DayOfWeek arrivalDay, DayOfWeek departureDay) {
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

    private boolean leavesLastDay() {
        return departureDay == DayOfWeek.SUNDAY;
    }

    private boolean arrivesFirstDay() {
        return arrivalDay == DayOfWeek.THURSDAY;
    }

    private int calculateStayDuration() {
        return departureDay.getValue() - arrivalDay.getValue() + 1;
    }
}