package series5.program.content.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FormPanel extends JPanel {
    private final ButtonGroup buttonGroup;
    private final JComboBox originie;
    private final JRadioButton button1;
    private final JRadioButton button2;
    private final JCheckBox scholarship;
    private final JCheckBox strange;
    private final JTextField matricule;
    private final JTextField firstname;
    private final JTextField lastname;
    private final JTextField dateOfBirth;
    private final JTextField section;

    public FormPanel() {
        this.setLayout(new GridLayout(8, 2, 5, 5));
        JLabel matriculeLabel = new JLabel("Matricule :");
        this.add(matriculeLabel);
        matricule = new JTextField();
        matricule.addActionListener(new TextListener());
        this.add(matricule);

        JLabel firstnameLabel = new JLabel("Prénom :");
        this.add(firstnameLabel);
        firstname = new JTextField();
        this.add(firstname);

        JLabel lastnameLabel = new JLabel("Prénom :");
        this.add(lastnameLabel);
        lastname = new JTextField();
        this.add(lastname);

        JLabel dateOfBirthLabel = new JLabel("Date de naissance :");
        this.add(dateOfBirthLabel);
        dateOfBirth = new JTextField();
        this.add(dateOfBirth);

        JLabel sectionLabel = new JLabel("Section :");
        this.add(sectionLabel);
        section = new JTextField();
        section.setEnabled(false);
        this.add(section);

        scholarship = new JCheckBox("Boursier");
        this.add(scholarship);
        strange = new JCheckBox("Etranger");
        this.add(strange);
        strange.addItemListener(new StrangeListener());

        JLabel origineLabel = new JLabel("Origine :");
        this.add(origineLabel);
        String[] values = {"Europe", "Afrique", "Asie", "Amérique", "Océanie"};
        originie = new JComboBox(values);
        originie.setSelectedItem("Europe");
        this.add(originie);
        originie.setEnabled(false);

        button1 = new JRadioButton("Nouvel étudiant", false);
        this.add(button1);
        button2 = new JRadioButton("Réinscription", false);
        this.add(button2);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);

        RadioListener radioListener = new RadioListener();
        button1.addItemListener(radioListener);
        button2.addItemListener(radioListener);
    }

    public void clearForm() {
        matricule.setText("");
        firstname.setText("");
        lastname.setText("");
        dateOfBirth.setText("");
        scholarship.setSelected(false);
        strange.setSelected(false);
        buttonGroup.clearSelection();
    }

    private class StrangeListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            originie.setEnabled(event.getStateChange() == ItemEvent.SELECTED);
        }
    }

    private class RadioListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == button1 && event.getStateChange() == ItemEvent.SELECTED && scholarship.isSelected()) {
                JOptionPane.showMessageDialog(null, "Vous devez vous rendre au secrétariat des étudiants ", "Attetion", JOptionPane.WARNING_MESSAGE);
            } else if (event.getSource() == button2 && event.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(null, "Vous devez compléter rapidement votre demande de PAE", "Attetion", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class TextListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == matricule) {
                int firstDigit = Integer.parseInt(matricule.getText().substring(0, 1));

                switch (firstDigit) {
                    case 1:
                        section.setText("Informatique de gestion");
                        break;
                    case 2:
                        section.setText("Technologie de l’informatique");
                        break;
                    case 3:
                        section.setText("Sécurité des systèmes");
                        break;
                    case 4:
                        section.setText("Comptabilité");
                        break;
                    case 5:
                        section.setText("Marketing");
                        break;
                    case 6:
                        section.setText("Automatique");
                        break;
                    case 7:
                        section.setText("Droit");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Le premier nombre du matricule doit être 1 et 7", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }
}
