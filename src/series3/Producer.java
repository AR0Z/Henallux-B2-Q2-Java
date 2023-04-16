package series3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Producer extends Thread {
    private final CommonZone commonZone;

    public Producer(CommonZone commonZone) {
        super("producteur");
        this.commonZone = commonZone;
    }

    public void run() {
        synchronized (commonZone) {
            try (FileInputStream fileInput = new FileInputStream("student.txt");
                 ObjectInputStream input = new ObjectInputStream(fileInput)) {
                while (fileInput.available() > 0) {
                    Thread.sleep((int) (Math.random() * 3000));
                    commonZone.setStudent((Student) input.readObject());
                    this.commonZone.notify();
                    this.commonZone.wait();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.commonZone.complete();
            this.commonZone.notify();
        }
    }
}