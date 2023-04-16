package series5.program.content;

import javax.swing.*;

public class Welcome extends JPanel {
    private final JLabel welcome;

    public Welcome() {
        this.setBounds(0, 10, 300, 290);
        welcome = new JLabel("Bienvenue sur mon super logiciel !");
        this.add(welcome);
    }
}
