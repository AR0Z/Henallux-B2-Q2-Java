package series4;

public class MovementThread extends Thread {
    private final Billiard billiard;

    public MovementThread(Billiard billiard) {
        this.billiard = billiard;
    }

    public void run() {
        while (true) {
            billiard.getBalls().forEach(Ball::move);
            billiard.getBalls().removeIf(Ball::isToEliminate);
            billiard.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
