package fr.lacombe;

import java.time.DayOfWeek;

public class Conference {

    private DayOfWeek firstDay;
    private DayOfWeek lastDay;

    public Conference(DayOfWeek firstDay, DayOfWeek lastDay) {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
    }

    boolean isConferenceDay(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() >= firstDay.getValue()
                && dayOfWeek.getValue() <= lastDay.getValue();
    }
}
