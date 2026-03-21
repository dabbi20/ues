ProjectParticipation p1 = new ProjectParticipation(80);
ProjectParticipation p2 = new ProjectParticipation(60);
ProjectParticipation p3 = new ProjectParticipation(65);
ProjectParticipation p4 = new ProjectParticipation(90);

List<ProjectParticipation> participations =
        List.of(p1, p2, p3, p4);

Project project = new Project(1L, "Proyecto Amazonia", participations);

// 🔥 crear observer
ProjectStatusObserver observer = new ProjectStatusObserver(project);

// 🔥 registrar observer
p1.addObserver(observer);
p2.addObserver(observer);
p3.addObserver(observer);
p4.addObserver(observer);

// 🔥 cambiar nota
p1.setGrade(50);

System.out.println(project.getStatus());