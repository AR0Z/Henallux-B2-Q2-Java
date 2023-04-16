package series2;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private final String firstname;
    private final String lastname;

    public enum Gender {
        F('f'), M('m'), X('x');

        private final char gender;

        Gender(char gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return Character.toString(gender);
        }
    }

    private final Gender gender;
    private final LocalDate birthday;

    public Person(String firstname, String lastname, Gender gender, int year, int month, int day) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = LocalDate.of(year, month, day);
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int age() {
        LocalDate curDate = LocalDate.now();
        return Period.between(birthday, curDate).getYears();
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " (" + age() + " ans)";
    }
}