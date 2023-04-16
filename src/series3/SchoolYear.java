package series3;

import java.io.Serializable;

public class SchoolYear implements Serializable {
    private final String sectionName;
    private int year;
    private final AcademicDegree academicDegree;

    public SchoolYear(String sectionName, int year, AcademicDegree academicDegree) {
        this.sectionName = sectionName;
        this.year = year;
        this.academicDegree = academicDegree;
    }

    public void setYear(int year) {
        if (year < 1 || 3 < year)
            year = 1;

        this.year = year;
    }

    @Override
    public String toString() {
        return academicDegree.toString() + " " + year + " en " + sectionName;
    }
}
