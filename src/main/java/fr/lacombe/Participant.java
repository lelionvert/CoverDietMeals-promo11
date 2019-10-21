package fr.lacombe;

import java.time.DayOfWeek;

class Participant {
    private Booking booking;
    private DietType diet;

    Participant(DietType diet, DayOfWeek arrivalDay, DayOfWeek departureDay) {
        this.diet = diet;
        booking = new Booking(arrivalDay, departureDay);
    }

    boolean isPescatarian() {
        return diet.equals(DietType.PESCATARIAN);
    }

    int calculateNbMeals() {
        return booking.calculateNbMeals();
    }
}
