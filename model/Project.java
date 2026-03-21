package model;

import observer.Observer;
import java.util.List;

public class Project implements Observer {

    private Long id;
    private String title;
    private List<ProjectParticipation> participations;
    private ProjectStatus status;

    public Project(Long id, String title, List<ProjectParticipation> participations) {
        this.id = id;
        this.title = title;
        this.participations = participations;
        this.status = ProjectStatus.ACTIVE;
    }

    @Override
    public void update() {
        evaluateProject();
    }

    public void evaluateProject() {
        int total = participations.size();
        int lowGrades = 0;

        for (ProjectParticipation p : participations) {
            if (p.isLowGrade()) {
                lowGrades++;
            }
        }

        if (total > 0 && (lowGrades * 100 / total) >= 50) {
            status = ProjectStatus.CLOSED;
            System.out.println("Proyecto cerrado automáticamente por bajo rendimiento");
        }
    }

    public ProjectStatus getStatus() {
        return status;
    }
}