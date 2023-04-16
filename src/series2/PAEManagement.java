package series2;

import series2.ManagerException.*;

public class PAEManagement {
    public static void main(String[] args) {
        try {
            Person person1 = new Person("Prof1", "LeProf", Person.Gender.M, 1976, 2, 26);
            Person person2 = new Person("Prof2", "LeProf", Person.Gender.M, 1977, 2, 26);
            Person person3 = new Person("Prof3", "LeProf", Person.Gender.M, 1978, 2, 26);

            LearningActivity activite1 = new LearningActivity("Java", person1);
            LearningActivity activite2 = new LearningActivity("C", person2);
            LearningActivity activite3 = new LearningActivity("C#", person3);

            Student student1 = new Student("Germain", "Duchêne", Person.Gender.M, 2001, 9, 24, "info", 2);

            student1.addLearningActivity(activite1);
            student1.addLearningActivity(activite2);
            student1.addLearningActivity(activite3);

            for (int i = 1; i <= student1.activitesNb(); i++) {
                System.out.println(student1.getLearningActivity(i));
            }

            for (int i = 1; i <= student1.activitesNb(); i++) {
                System.out.println(student1.getLearningActivity(i).getTeatcher());
            }

            System.out.println(student1.getLearningActivity(-2));

        } catch (SectionException sectionException) {
            System.out.println(sectionException.getMessage());
        } catch (YearNumberException yearNumberException) {
            System.out.println(yearNumberException.getMessage());
        } catch (TooManyActivities tooManyActivities) {
            System.out.println(tooManyActivities.getMessage());
        } catch (BadPositionException badPositionException) {
            System.out.println(badPositionException.getMessage());
        }
    }
}
