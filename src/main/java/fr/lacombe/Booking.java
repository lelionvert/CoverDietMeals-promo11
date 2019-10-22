package fr.lacombe;

import java.time.DayOfWeek;

class Booking {
    private DayOfWeek arrivalDay;
    private DayOfWeek departureDay;

    Booking(DayOfWeek arrivalDay, DayOfWeek departureDay) {
        this.arrivalDay = arrivalDay;
        this.departureDay = departureDay;
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