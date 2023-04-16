package series2.ManagerException;

public class YearNumberException extends Exception {
    private int wrongYearNumber;

    public YearNumberException(int wrongYearNumber, String message) {
        super(message);
        setWrongYearNumber(wrongYearNumber);
    }

    public int getWrongYearNumber() {
        return wrongYearNumber;
    }

    public void setWrongYearNumber(int wrongYearNumber) {
        this.wrongYearNumber = wrongYearNumber;
    }
}
