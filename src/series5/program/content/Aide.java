package series5.program.content;

import series5.program.MainWindow;
import series5.program.listener.WindowListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aide extends JFrame {

    public Aide() {
        super("Aide");
        setSize(300, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2 - 25);
        setResizable(false);
        this.setLayout(new FlowLayout());
        JLabel texte = new JLabel("<html> <body><p>text d'aide wola</p></body> </html>");
        this.add(texte);
        JButton backButton = new JButton("Retour à la fenêtre principale");
        this.add(backButton);
        backButton.addActionListener(new ButtonListener());

        this.addWindowListener(new WindowListener());
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Aide.this.dispose();
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        }
    }
}
