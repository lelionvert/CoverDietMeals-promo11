package fr.lacombe;

import java.time.DayOfWeek;

class Participant {
    private Booking booking;
    private DietType diet;
    private final DayOfWeek arrivalDay;
    private final DayOfWeek departureDay;

    Participant(DietType diet, DayOfWeek arrivalDay, DayOfWeek departureDay) {
        this.diet = diet;
        this.arrivalDay = arrivalDay;
        this.departureDay = departureDay;
        booking = new Booking(arrivalDay, departureDay);
}

    boolean isPescatarian() {
        return diet.equals(DietType.PESCATARIAN);
    }

    boolean leavesLastDay() {
        return this.booking.leavesLastDay();
    }

    boolean arrivesFirstDay() {
        return  this.booking.arrivesFirstDay();
    }

    int getStayDuration() {
        return  booking.calculateStayDuration();
    }

    boolean isPresent(DayOfWeek day){
        return day.getValue() >= arrivalDay.getValue() && day.getValue() <= departureDay.getValue();
    }

    boolean isDietType(DietType dietType) {
        return dietType == diet;
    }
}
