package external;

public class ExternalIccisProject {

    private String researchCode;
    private String researchName;
    private String courseName;
    private String leadResearcher;

    public ExternalIccisProject(String researchCode, String researchName, String courseName, String leadResearcher) {
        this.researchCode = researchCode;
        this.researchName = researchName;
        this.courseName = courseName;
        this.leadResearcher = leadResearcher;
    }

    public String getResearchCode() {
        return researchCode;
    }

    public String getResearchName() {
        return researchName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLeadResearcher() {
        return leadResearcher;
    }
}