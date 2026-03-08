# UES – ICCIS Academic Management System

##  Descripción

Este proyecto consiste en el desarrollo de un **backend académico sencillo** para la **Universidad Élite Suramericana (UES)** en alianza con el **Instituto Colombiano de Ciencias e Investigación para la Salud (ICCIS)**.

El sistema busca modelar y administrar la información relacionada con:

- Facultades
- Cursos
- Profesores
- Estudiantes
- Proyectos de investigación
- Evaluaciones académicas

El objetivo principal es diseñar un sistema **escalable y organizado**, aplicando **Patrones de Diseño Creacionales**, específicamente el patrón **Factory Method**.

---

#  Objetivo del proyecto

Diseñar un sistema que permita representar las relaciones académicas entre estudiantes, profesores, cursos y proyectos de investigación, respetando las siguientes reglas del negocio:

- Cada curso pertenece a una facultad.
- Cada curso tiene un profesor asignado.
- Un profesor puede dictar varios cursos.
- Cada profesor solo puede tener **un proyecto asociado**.
- Un estudiante puede estar inscrito en **varios cursos**.
- Cada estudiante debe participar en **al menos un proyecto**.
- Cada participación en un proyecto tiene una **calificación individual**.
- Si **50% o más de las calificaciones son menores a 70**, el proyecto se **cierra automáticamente**.

---

#  Arquitectura del proyecto

El proyecto está organizado en diferentes paquetes para mantener una separación clara de responsabilidades.

ues-system

│
├── model

│ ├── Faculty

│ ├── Course

│ ├── Professor

│ ├── Student

│ ├── Project

│ ├── ProjectParticipation

│ ├── Country

│ └── ProjectStatus
│
├── factory

│ ├── UniversityFactory

│ └── DefaultUniversityFactory

│
├── service

│
└── main

└── Ap


---

#  Modelo de dominio

Las entidades principales del sistema son:

| Clase | Descripción |
|------|-------------|
| Faculty | Representa una facultad de la universidad |
| Course | Representa un curso o materia |
| Professor | Representa un docente |
| Student | Representa un estudiante |
| Project | Representa un proyecto de investigación |
| ProjectParticipation | Representa la participación de un estudiante en un proyecto |
| Country | Enum con el país de origen del estudiante |
| ProjectStatus | Enum con el estado del proyecto |

---

#  Relaciones principales

Las relaciones del sistema están diseñadas de la siguiente manera:

### Faculty → Course
Una facultad puede tener múltiples cursos.

### Professor → Course
Un profesor puede dictar varios cursos.

### Student ↔ Course
Un estudiante puede estar inscrito en múltiples cursos.

### Professor → Project
Cada profesor solo puede tener un proyecto.

### Course → Project
Cada proyecto pertenece a un curso.

### Student ↔ Project
Los estudiantes participan en proyectos a través de la entidad `ProjectParticipation`.

---

#  Patrón de diseño utilizado

## Factory Method

El patrón **Factory Method** permite centralizar la creación de objetos del dominio en una clase especializada llamada **Factory**.

En este proyecto se implementa mediante:

UniversityFactory
DefaultUniversityFactory


Esta fábrica es responsable de crear:

- estudiantes
- profesores
- cursos
- proyectos

Esto permite:

- reducir el acoplamiento entre clases
- centralizar reglas de negocio
- facilitar cambios futuros en el sistema

---

#  Ejecución del proyecto

La ejecución se realiza desde la clase principal:
main.App

Flujo básico del sistema:

1. Crear una facultad.
2. Crear un profesor mediante la fábrica.
3. Crear un curso.
4. Crear estudiantes.
5. Crear un proyecto asociado a un curso y profesor.

---

# 📌 Ejemplo de uso del Factory Method

```java
UniversityFactory factory = new DefaultUniversityFactory();

Professor professor = factory.createProfessor(
    1L, 
    "Carlos Ruiz", 
    "Investigacion"
);

Student student = factory.createStudent(
    1L, 
    "Ana", 
    Country.COLOMBIA
);

Course course = factory.createCourse(
    1L, 
    "Programacion", 
    faculty
);

Project project = factory.createProject(
    1L,
    "Proyecto Amazonia",
    course,
    professor
);


