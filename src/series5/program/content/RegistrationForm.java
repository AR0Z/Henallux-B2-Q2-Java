package series5.program.content;

import series5.program.MainWindow;
import series5.program.content.form.ButtonsPanel;
import series5.program.content.form.FormPanel;

import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JPanel {
    private Container frameContainer;

    public RegistrationForm(MainWindow mainWindow) {
        this.setLayout(new BorderLayout());
        FormPanel formPanel = new FormPanel();
        this.add(formPanel, BorderLayout.CENTER);
        this.add(new ButtonsPanel(formPanel, mainWindow), BorderLayout.SOUTH);
    }
}
