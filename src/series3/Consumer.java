package series3;

public class Consumer extends Thread {
    private final CommonZone commonZone;

    public Consumer(CommonZone commonZone) {
        super("consommateur");
        this.commonZone = commonZone;
    }

    public void run() {
        synchronized (commonZone) {
            while (!commonZone.isCompleted()) {
                try {
                    Thread.sleep((int) (Math.random() * 3000));
                    Student student = commonZone.getStudent();
                    if (student == null)
                        commonZone.wait();
                    else {
                        System.out.println(student);
                        commonZone.setStudent(null);
                        commonZone.notify();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
