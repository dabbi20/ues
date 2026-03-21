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

- En la **primera parte** se implementó el patrón **Factory Method**
- En la **segunda parte** se implementó el patrón **Adapter**
- En la **tercera parte** se implementa el patrón **Observer**

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

Además, el sistema debe poder:

- integrar información externa (ICCIS)
- reaccionar automáticamente ante cambios en las evaluaciones

---

# Modelo de dominio

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

Clase externa:

| Clase | Descripción |
|------|-------------|
| ExternalIccisProject | Formato externo de proyectos del ICCIS |

---

# Relaciones principales

## Faculty → Course
Una facultad puede tener múltiples cursos.

## Professor → Course
Un profesor puede dictar varios cursos.

## Student ↔ Course
Un estudiante puede estar inscrito en múltiples cursos.

## Professor → Project
Cada profesor solo puede tener un proyecto.

## Course → Project
Cada proyecto pertenece a un curso.

## Student ↔ Project
Los estudiantes participan en proyectos mediante `ProjectParticipation`.

---

# Arquitectura del proyecto

```text
ues-system
│
├── model
├── external
├── adapter
├── factory
├── observer
└── main

Patrones de diseño utilizados
1. Factory Method (Creacional)

Permite centralizar la creación de objetos.

Ventajas:
reduce acoplamiento
centraliza lógica de creación
facilita mantenimiento
Ejemplo:
UniversityFactory factory = new DefaultUniversityFactory();

Professor professor = factory.createProfessor(
    1L,
    "Carlos Ruiz",
    "Investigacion"
);
2. Adapter (Estructural)

Permite integrar el formato externo del ICCIS con el sistema interno.

Problema:

ICCIS usa un formato diferente al de la UES.

Solución:

Se implementa un adaptador:

IccisProjectTarget
IccisProjectAdapter
Flujo:
ICCIS → ExternalIccisProject → Adapter → UES
Beneficios:
desacopla sistemas
evita modificar clases internas
facilita integración externa
3. Observer (Comportamiento)

Permite que el sistema reaccione automáticamente a cambios en las evaluaciones.

Problema:

Cuando cambian las notas, el proyecto debe evaluarse automáticamente.

Solución:

Se implementa el patrón Observer:

Subject → ProjectParticipation
Observer → ProjectStatusObserver
Flujo:
Cambio de nota
        ↓
ProjectParticipation
        ↓
notifyObservers()
        ↓
ProjectStatusObserver
        ↓
evalúa proyecto
        ↓
puede cerrarlo
Beneficios:
desacopla lógica de negocio
permite comportamiento dinámico
mejora escalabilidad
Regla de evaluación automática

Si el 50% o más de las calificaciones son menores a 70:

ProjectStatus = CLOSED

En caso contrario:

ProjectStatus = ACTIVE
Ejemplo de comportamiento (Observer)
p1.setGrade(50); // dispara notificación

// automáticamente:
→ observer.update()
→ evalúa proyecto
→ puede cerrarse
Diferencia entre las partes del proyecto
Parte	Patrón	Enfoque
1	Factory Method	creación
2	Adapter	estructura
3	Observer	comportamiento
Decisiones de diseño

Se eligió Observer porque el sistema requiere reaccionar automáticamente a cambios en las evaluaciones, lo cual representa un caso claro de notificación de eventos.

Se eligió Adapter para desacoplar la estructura externa del ICCIS del modelo interno.

Se utilizó Factory Method para mantener una creación organizada de objetos.

Tecnologías utilizadas
Java
Programación Orientada a Objetos
Patrones de Diseño (Creacional, Estructural, Comportamiento)
Posibles mejoras
persistencia en base de datos
API REST
autenticación
control de acceso (Proxy)
múltiples estrategias de evaluación (Strategy)
Autor

Proyecto académico – Patrones de Diseño
Asturias Corporación Universitaria