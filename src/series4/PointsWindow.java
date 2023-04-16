package series4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PointsWindow extends JFrame {
    private final CounterPanel counterPanel;
    private final Container mainContainer;

    public PointsWindow(Billiard billiard) {
        // Appel au constructeur hérité en donnant un titre à la fenêtre
        super("");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;

        // Positionnement de la fenêtre à l’écran :
        setBounds(centerX - 310 / 2, centerY - 600 / 2 - 40, 310, 75);
        // Gestion de la fermeture de la fenêtre si clic sur icône X :
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Création d’une occurrence du panel représentant le billard
        counterPanel = new CounterPanel(billiard);
        // Récupération de la référence du conteneur de la fenêtre :
        mainContainer = this.getContentPane();
        /* Ajout du billard au conteneur de la fenêtre via le gestionnaire de tracé par défaut */
        mainContainer.add(counterPanel);

        PointsCountingThread pointsCountingThread = new PointsCountingThread(counterPanel);
        pointsCountingThread.start();

        // Affichage de la fenêtre :
        setVisible(true);
    }
}
