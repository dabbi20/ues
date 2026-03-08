package factory;

import model.*;

public class DefaultUniversityFactory implements UniversityFactory {

    @Override
    public Student createStudent(Long id, String name, Country country) {
        return new Student(id, name, country);
    }

    @Override
    public Professor createProfessor(Long id, String name, String specialty) {
        return new Professor(id, name, specialty);
    }

    @Override
    public Course createCourse(Long id, String name, Faculty faculty) {
        return new Course(id, name, faculty);
    }

    @Override
    public Project createProject(Long id, String title, Course course, Professor professor) {

        if (!professor.canTakeProject()) {
            throw new RuntimeException("El profesor ya tiene un proyecto asignado");
        }

        return new Project(id, title, course, professor);
    }

}