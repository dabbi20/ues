package main;

import factory.DefaultUniversityFactory;
import factory.UniversityFactory;
import model.*;
package main;

import adapter.IccisProjectAdapter;
import adapter.IccisProjectTarget;
import external.ExternalIccisProject;

public class App {

    public static void main(String[] args) {

        ExternalIccisProject externalProject =
                new ExternalIccisProject(
                        "ICCIS-101",
                        "Amazonic Medicinal Plants Research",
                        "Software Design",
                        "Carlos Ruiz"
                );

        IccisProjectTarget adaptedProject = new IccisProjectAdapter(externalProject);

        System.out.println("Proyecto adaptado al sistema UES:");
        System.out.println("ID: " + adaptedProject.getProjectId());
        System.out.println("Titulo: " + adaptedProject.getProjectTitle());
        System.out.println("Curso: " + adaptedProject.getCourseName());
        System.out.println("Profesor: " + adaptedProject.getProfessorName());
    }
}