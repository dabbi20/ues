package adapter;

import external.ExternalIccisProject;

public class IccisProjectAdapter implements IccisProjectTarget {

    private ExternalIccisProject externalProject;

    public IccisProjectAdapter(ExternalIccisProject externalProject) {
        this.externalProject = externalProject;
    }

    @Override
    public Long getProjectId() {
        String code = externalProject.getResearchCode().replace("ICCIS-", "");
        return Long.parseLong(code);
    }

    @Override
    public String getProjectTitle() {
        return externalProject.getResearchName();
    }

    @Override
    public String getCourseName() {
        return externalProject.getCourseName();
    }

    @Override
    public String getProfessorName() {
        return externalProject.getLeadResearcher();
    }
}