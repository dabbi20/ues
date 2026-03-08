package model;

import java.util.List;

public class Faculty {

    private Long id;
    private String name;
    private List<Course> courses;

    public Faculty(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}