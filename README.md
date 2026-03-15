# UES – ICCIS Academic Management System

## Descripción

Este proyecto consiste en el desarrollo de un **backend académico sencillo** para la **Universidad Élite Suramericana (UES)** en alianza con el **Instituto Colombiano de Ciencias e Investigación para la Salud (ICCIS)**.

El sistema busca modelar y administrar la información relacionada con:

- Facultades
- Cursos
- Profesores
- Estudiantes
- Proyectos de investigación
- Evaluaciones académicas

El objetivo principal es diseñar un sistema **escalable, organizado y mantenible**, aplicando **Patrones de Diseño de Software**.

En la primera parte del proyecto se aplicó el patrón **Factory Method**, y en esta segunda parte se implementa el patrón estructural **Adapter** para integrar información externa.

---

# Objetivo del proyecto

Diseñar un sistema que permita representar las relaciones académicas entre estudiantes, profesores, cursos y proyectos de investigación, respetando las siguientes reglas del negocio:

- Cada curso pertenece a una facultad.
- Cada curso tiene un profesor asignado.
- Un profesor puede dictar varios cursos.
- Cada profesor solo puede tener **un proyecto asociado**.
- Un estudiante puede estar inscrito en **varios cursos**.
- Cada estudiante debe participar en **al menos un proyecto**.
- Cada participación en un proyecto tiene una **calificación individual**.
- Si **50% o más de las calificaciones son menores a 70**, el proyecto se **cierra automáticamente**.

Además, el sistema debe poder **integrar información externa proveniente del ICCIS**, incluso cuando esa información tenga un formato diferente al utilizado por el sistema interno de la UES.

---
# Modelo de dominio

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

También se incorpora una clase externa que representa el formato de datos del ICCIS.

| Clase | Descripción |
|------|-------------|
| ExternalIccisProject | Representa el formato externo de proyectos proporcionado por ICCIS |

---

# Relaciones principales

Las relaciones del sistema están diseñadas de la siguiente manera.

## Faculty → Course
Una facultad puede tener múltiples cursos.

## Professor → Course
Un profesor puede dictar varios cursos.

## Student ↔ Course
Un estudiante puede estar inscrito en múltiples cursos.

## Professor → Project
Cada profesor solo puede tener un proyecto asociado.

## Course → Project
Cada proyecto pertenece a un curso.

## Student ↔ Project
Los estudiantes participan en proyectos a través de la entidad **ProjectParticipation**.

---

# Patrones de diseño utilizados

## Factory Method

En la primera parte del proyecto se utilizó el patrón creacional **Factory Method**, el cual permite centralizar la creación de objetos del dominio.

La fábrica es responsable de crear:

- estudiantes
- profesores
- cursos
- proyectos

Esto permite:

- reducir el acoplamiento entre clases
- centralizar reglas de negocio
- facilitar modificaciones futuras

### Ejemplo de uso

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

# Arquitectura del proyecto

El proyecto está organizado en diferentes paquetes para mantener una separación clara de responsabilidades.

```text
ues-system
│
├── model
│   ├── Faculty.java
│   ├── Course.java
│   ├── Professor.java
│   ├── Student.java
│   ├── Project.java
│   ├── ProjectParticipation.java
│   ├── Country.java
│   └── ProjectStatus.java
│
├── external
│   └── ExternalIccisProject.java
│
├── adapter
│   ├── IccisProjectTarget.java
│   └── IccisProjectAdapter.java
│
├── factory
│   ├── UniversityFactory.java
│   └── DefaultUniversityFactory.java
│
└── main
    └── App.java
