package model;

import observer.Subject;

public class ProjectParticipation extends Subject {

    private double grade;

    public ProjectParticipation(double grade) {
        this.grade = grade;
    }


    public void setGrade(double grade) {
        this.grade = grade;
        notifyObservers(); // 🔥 clave
    }

    public boolean isLowGrade() {
        return grade < 70;
    }
}