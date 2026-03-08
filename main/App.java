package main;

import factory.DefaultUniversityFactory;
import factory.UniversityFactory;
import model.*;

public class App {

    public static void main(String[] args) {

        UniversityFactory factory = new DefaultUniversityFactory();

        Faculty faculty = new Faculty(1L, "Ingenieria");

        Professor professor = factory.createProfessor(1L, "Carlos Ruiz", "Investigacion");

        Course course = factory.createCourse(1L, "Programacion", faculty);

        Student s1 = factory.createStudent(1L, "Ana", Country.COLOMBIA);
        Student s2 = factory.createStudent(2L, "Luis", Country.PERU);

        Project project = factory.createProject(1L, "Proyecto Amazonia", course, professor);

        System.out.println("Sistema creado correctamente");

    }

}