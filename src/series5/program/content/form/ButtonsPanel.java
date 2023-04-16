package series5.program.content.form;

import series5.program.MainWindow;
import series5.program.content.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    public ButtonsPanel(FormPanel formPanel, MainWindow mainWindow) {
        this.setLayout(new FlowLayout());

        JButton backButton = new JButton("Retour");
        this.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.changeContenu(new Welcome());
            }
        });

        JButton validateButton = new JButton("Validation");
        this.add(validateButton);

        JButton resetButton = new JButton("Réinitialisation");
        this.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formPanel.clearForm();
            }
        });
    }
}
