package series5.program;

import series5.program.content.Aide;
import series5.program.content.IesnInformation;
import series5.program.content.RegistrationForm;
import series5.program.listener.ActionExit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    MainWindow mainWindow;
    private final JMenu application, etudiant, infos;
    private final JMenuItem quitter, inscription, iesn, aide;

    public MenuBar(MainWindow mainWindow) {
        super();

        this.mainWindow = mainWindow;

        application = new JMenu("Application");
        quitter = new JMenuItem("Quitter");
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));

        add(application);
        application.add(quitter);

        quitter.addActionListener(new ActionExit());

        etudiant = new JMenu("Etudiant");
        inscription = new JMenuItem("Inscription");

        etudiant.add(inscription);
        add(etudiant);

        infos = new JMenu("Infos");
        iesn = new JMenuItem("IESN");
        aide = new JMenuItem("Aide");

        infos.add(iesn);
        infos.add(aide);
        add(infos);

        iesn.addActionListener(new IesnListener());
        aide.addActionListener(new AideListener());
        inscription.addActionListener(new InscriptionListener());
    }

    private class IesnListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            mainWindow.changeContenu(new IesnInformation());
        }
    }

    private class AideListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Aide aide = new Aide();
            aide.setVisible(true);
            mainWindow.dispose();
        }
    }

    private class InscriptionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            mainWindow.changeContenu(new RegistrationForm(mainWindow));
        }
    }
}
