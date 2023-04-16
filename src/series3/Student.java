package series3;

import java.io.Serializable;

public class Student implements Serializable {
    private final String firstname;
    private final String lastname;
    SchoolYear schoolYear;

    public Student(String firstname, String lastname, SchoolYear schoolYear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " est étudiant(e) en " + schoolYear;
    }
}
