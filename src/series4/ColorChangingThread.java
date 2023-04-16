package series4;

public class ColorChangingThread extends Thread {

    private final Billiard billiard;

    public ColorChangingThread(Billiard billiard) {
        this.billiard = billiard;
    }

    public void run() {
        while (true) {
            billiard.getBalls().forEach(ball -> ball.changeColor());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
