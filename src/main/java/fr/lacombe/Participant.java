package fr.lacombe;

class Participant {
    private String diet;
    private String day;

    Participant(String diet, String day) {
        this.diet = diet;
        this.day = day;
    }

    String getDay() {
        return day;
    }

    String getDiet() {
        return diet;
    }
}
