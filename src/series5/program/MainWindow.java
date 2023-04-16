package series5.program;

import series5.program.content.Welcome;
import series5.program.listener.WindowListener;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel main;

    public MainWindow() {
        super("Welcome");
        setSize(350, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2 - 25);
        setResizable(false);
        addWindowListener(new WindowListener());
        setJMenuBar(new MenuBar(this));
        main = new Welcome();
        add(main);
        setLayout(new FlowLayout());
    }

    public void changeContenu(JPanel element) {
        remove(main);
        main = element;
        add(main);
        repaint();
        revalidate();
    }
}
