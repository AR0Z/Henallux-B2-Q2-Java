package series4;

import javax.swing.*;
import java.awt.*;

public class CounterPanel extends JPanel {
    private final Billiard billiard;

    public CounterPanel(Billiard billiard) {
        this.billiard = billiard;
    }

    public void paint(Graphics g) {
        g.drawString(billiard.getTotalPoints() + " points", 10, 25);
    }
}
