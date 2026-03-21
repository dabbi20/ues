package observer;

import model.Project;
import model.ProjectParticipation;
import model.ProjectStatus;

import java.util.List;

public class ProjectStatusObserver implements Observer {

    private Project project;

    public ProjectStatusObserver(Project project) {
        this.project = project;
    }

    @Override
    public void update() {
        evaluateProject();
    }

    private void evaluateProject() {

        List<ProjectParticipation> participations = project.getParticipations();

        int total = participations.size();
        int lowGrades = 0;

        for (ProjectParticipation p : participations) {
            if (p.isLowGrade()) {
                lowGrades++;
            }
        }

        if (total > 0 && (lowGrades * 100 / total) >= 50) {
            project.setStatus(ProjectStatus.CLOSED);
            System.out.println("Proyecto cerrado automáticamente (Observer)");
        }
    }
}