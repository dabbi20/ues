package model;

import java.util.List;

public class Course {

    private Long id;
    private String name;
    private Faculty faculty;
    private Professor professor;
    private List<Student> students;
    private List<Project> projects;

    public Course(Long id, String name, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
    }

}