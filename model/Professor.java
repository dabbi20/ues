package model;

import java.util.List;

public class Professor {

    private Long id;
    private String name;
    private String specialty;
    private List<Course> courses;
    private Project assignedProject;

    public Professor(Long id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public boolean canTakeProject() {
        return assignedProject == null;
    }

}