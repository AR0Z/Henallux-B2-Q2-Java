package series4;

public class PointsCountingThread extends Thread {
    private final CounterPanel counterPanel;

    public PointsCountingThread(CounterPanel counterPanel) {
        this.counterPanel = counterPanel;
    }

    public void run() {
        while (true) {
            counterPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
