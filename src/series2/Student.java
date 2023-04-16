package series2;

import series2.ManagerException.*;

public class Student extends Person {

    public final int NB_MAX_ACTIVITY = 5;

    private String sectionName;
    private int studyYearNumber;
    private final LearningActivity[] activites;

    public static int studentNbr = 0;
    public static int girlNbr = 0;

    public Student(String firstname, String lastname, Gender gender, int year, int month, int day, String sectionName, int studyYearNumber) throws SectionException, YearNumberException {
        super(firstname, lastname, gender, year, month, day);
        setSectionName(sectionName);
        setStudyYearNumber(studyYearNumber);
        activites = new LearningActivity[NB_MAX_ACTIVITY];

        studentNbr++;
        if (this.getGender() == Gender.F) {
            girlNbr++;
        }
    }

    public static double percentageGirls() {
        return (double) girlNbr / studentNbr * 100;
    }

    public void setSectionName(String sectionName) throws SectionException {
        if (sectionName.equals("compta") && sectionName.equals("droit") && sectionName.equals("market") && sectionName.equals("info"))
            throw new SectionException(sectionName, "La valeur " + sectionName + " proposée pour le section est invalide.");
        this.sectionName = sectionName;
    }

    public void setStudyYearNumber(int studyYearNumber) throws YearNumberException {
        if (studyYearNumber != 1 && studyYearNumber != 2 && studyYearNumber != 3)
            throw new YearNumberException(studyYearNumber, "La valeur " + studyYearNumber + " proposée pour l’année  est invalide.");
        this.studyYearNumber = studyYearNumber;
    }

    public String loginName() {
        return sectionName.charAt(0) + getLastname() + getFirstname().charAt(0);
    }

    public int activitesNb() {
        int activitesNb = 0;

        for (int i = 0; i < NB_MAX_ACTIVITY; i++) {
            if (activites[i] != null) {
                activitesNb++;
            }
        }

        return activitesNb;
    }

    public void addLearningActivity(LearningActivity activite) throws TooManyActivities {
        int activitesNb = activitesNb();
        if (activitesNb >= NB_MAX_ACTIVITY)
            throw new TooManyActivities("Le nombre maximum d’activités d’apprentissage permis est déjà atteint !");

        activites[activitesNb] = activite;
    }

    public LearningActivity getLearningActivity(int index) throws BadPositionException {
        if (index <= 0 || index > activitesNb()) {
            String message;
            if (index <= 0)
                message = "Le numéro d’activité d’apprentissage " + index + " que vous avez proposé est <= 0";
            else
                message = "L’étudiant n’a que " + activitesNb() + " activités d’apprentissage dans son PAE. Le numéro " + index + " que vous avez proposé ne correspond donc pas à une activité d’apprentissage du PAE de cet étudiant";
            throw new BadPositionException(message, index, activitesNb());
        }
        return activites[index - 1];
    }

    @Override
    public String toString() {
        return super.toString() + " est inscrit" + (getGender() == Gender.F ? "e" : "") + " en " + studyYearNumber + "e " + sectionName + ".\nSon nom d'utilisateur est " + loginName();
    }
}
