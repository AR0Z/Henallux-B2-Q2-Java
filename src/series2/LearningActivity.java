package series2;

public class LearningActivity {
    private final String title;
    private final Person teatcher;

    public LearningActivity(String title, Person teatcher) {
        this.title = title;
        this.teatcher = teatcher;
    }

    public Person getTeatcher() {
        return teatcher;
    }

    @Override
    public String toString() {
        return "l'activité d'apprentisage intitulée " + title + " donnée par " + teatcher;
    }
}
