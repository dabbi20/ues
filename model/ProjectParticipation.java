package model;

public class ProjectParticipation {

    private Student student;
    private Project project;
    private double grade;

    public ProjectParticipation(Student student, Project project, double grade) {
        this.student = student;
        this.project = project;
        this.grade = grade;
    }

    public boolean isLowGrade() {
        return grade < 70;
    }

}