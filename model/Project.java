package model;

import java.util.List;

public class Project {

    private Long id;
    private String title;
    private Course course;
    private Professor professor;
    private ProjectStatus status;
    private List<ProjectParticipation> participations;

    public Project(Long id, String title, Course course, Professor professor) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.professor = professor;
        this.status = ProjectStatus.ACTIVE;
    }

}