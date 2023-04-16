package series2.ManagerException;

public class SectionException extends Exception {
    private String wrongSectionName;

    public SectionException(String wrongSectionName, String message) {
        super(message);
        setWrongSectionName(wrongSectionName);
    }

    public String getWrongSectionName() {
        return wrongSectionName;
    }

    public void setWrongSectionName(String wrongSectionName) {
        this.wrongSectionName = wrongSectionName;
    }
}
