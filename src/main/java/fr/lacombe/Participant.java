package fr.lacombe;

public class Participant {
    private String diet;
    private String day;

    public Participant(String diet) {
        this.diet = diet;
    }

    public Participant(String diet, String day) {
        this.diet = diet;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getDiet() {
        return diet;
    }
}
