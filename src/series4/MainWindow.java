package series4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private final Billiard billiard;
    private final Container mainContainer;
    private final int width = 300;
    private final int height = 600;


    public MainWindow() {
        // Appel au constructeur hérité en donnant un titre à la fenêtre
        super("Billiard");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;

        // Positionnement de la fenêtre à l’écran :
        setBounds(centerX - width / 2, centerY - height / 2, width, height);
        // Gestion de la fermeture de la fenêtre si clic sur icône X :
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Création d’une occurrence du panel représentant le billard
        billiard = new Billiard();
        // Récupération de la référence du conteneur de la fenêtre :
        mainContainer = this.getContentPane();
        /* Ajout du billard au conteneur de la fenêtre via le gestionnaire de tracé par défaut */
        mainContainer.add(billiard);
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));

        JButton button = new JButton("Start");
        mainContainer.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                billiard.getBalls().add(new Ball(billiard, 10, 10, 200, 450));
            }
        });

        // Affichage de la fenêtre :
        setVisible(true);

        PointsWindow pointsWindow = new PointsWindow(billiard);
    }
}
