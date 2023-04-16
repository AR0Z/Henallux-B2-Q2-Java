package series3;

public class Main {
    public static void main(String[] args) {
        SchoolYear informatique1 = new SchoolYear("Informatique", 1, AcademicDegree.BACHELOR);
        SchoolYear informatique2 = new SchoolYear("Informatique", 2, AcademicDegree.BACHELOR);
        SchoolYear informatique3 = new SchoolYear("Informatique", 3, AcademicDegree.BACHELOR);

        Student germain = new Student("Germain", "Duchêne", informatique2);
        Student thérence = new Student("Thérence", "Guerenne-Courtois", informatique2);
        Student erwann = new Student("Erwann", "Charlier", informatique2);
        Student thomas = new Student("Thomas", "Laurent", informatique2);

        /*try (FileOutputStream fileOutput = new FileOutputStream("student.txt");
             ObjectOutputStream output = new ObjectOutputStream(fileOutput)) {
            output.writeObject(germain);
            output.writeObject(thérence);
            output.writeObject(erwann);
            output.writeObject(thomas);
        } catch (IOException ioException) {

        }*/
        CommonZone commonZone = new CommonZone();
        Producer producer = new Producer(commonZone);
        Consumer consumer = new Consumer(commonZone);

        producer.start();
        consumer.start();

    }
}