package model;

public class Project {

    private Long id;
    private String title;
    private Course course;
    private Professor professor;
    private ProjectStatus status;

    public Project(Long id, String title, Course course, Professor professor) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.professor = professor;
        this.status = ProjectStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Course getCourse() {
        return course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Project{id=" + id +
                ", title='" + title + '\'' +
                ", course=" + course.getName() +
                ", professor=" + professor.getName() +
                ", status=" + status + '}';
    }
}