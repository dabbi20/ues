package model;

import java.util.List;

public class Student {

    private Long id;
    private String name;
    private Country country;
    private List<Course> courses;
    private List<ProjectParticipation> participations;

    public Student(Long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

}