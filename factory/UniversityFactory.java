package factory;

import model.*;

public interface UniversityFactory {

    Student createStudent(Long id, String name, Country country);

    Professor createProfessor(Long id, String name, String specialty);

    Course createCourse(Long id, String name, Faculty faculty);

    Project createProject(Long id, String title, Course course, Professor professor);

}