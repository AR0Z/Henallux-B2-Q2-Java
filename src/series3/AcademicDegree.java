package series3;

public enum AcademicDegree {
    BACHELOR("bac"),
    MASTER("master");

    private final String text;

    AcademicDegree(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
