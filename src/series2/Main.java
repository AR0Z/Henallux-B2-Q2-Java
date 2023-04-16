package series2;

import series2.ManagerException.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int addStudent = JOptionPane.YES_OPTION;
        while (addStudent == JOptionPane.YES_OPTION) {
            String firstname = JOptionPane.showInputDialog(null, "Veuillez entrée le prénom de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String lastname = JOptionPane.showInputDialog(null, "Veuillez entrée le nom de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String genderChar = JOptionPane.showInputDialog(null, "Veuillez entrée le genre de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String year = JOptionPane.showInputDialog(null, "Veuillez entrée l'année de naissance de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String month = JOptionPane.showInputDialog(null, "Veuillez entrée le mois de naissance de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String day = JOptionPane.showInputDialog(null, "Veuillez entrée le jour de naissance de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String sectionName = JOptionPane.showInputDialog(null, "Veuillez entrée la section de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            String studyYearNumber = JOptionPane.showInputDialog(null, "Veuillez entrée l'année de l'étudiant", "Inscription étudint", JOptionPane.QUESTION_MESSAGE);
            try {
                Person.Gender gender;
                if (genderChar.charAt(0) == 'm') {
                    gender = Person.Gender.M;
                } else if (genderChar.charAt(0) == 'f') {
                    gender = Person.Gender.F;
                } else {
                    gender = Person.Gender.X;
                }
                Student student1 = new Student(firstname, lastname, gender, Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), sectionName, Integer.parseInt(studyYearNumber));
                JOptionPane.showMessageDialog(null, student1.toString(), "Confirmation d'inscription", JOptionPane.INFORMATION_MESSAGE);
            } catch (SectionException sectionException) {
                JOptionPane.showMessageDialog(null, sectionException.getMessage(), "Section non acceptée", JOptionPane.ERROR_MESSAGE);
            } catch (YearNumberException yearNumberException) {
                JOptionPane.showMessageDialog(null, yearNumberException.getMessage(), "Année d’inscription non acceptée", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, numberFormatException.getMessage(), "Mauvaise valeur", JOptionPane.ERROR_MESSAGE);
            }

            addStudent = JOptionPane.showConfirmDialog(null, "Voulez vous rajoutez d'autre étudiant", "Ajout étudiant", JOptionPane.YES_NO_OPTION);
        }

        JOptionPane.showMessageDialog(null, (int) Student.percentageGirls() + " % de fille", "Pourcentage de fille", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
