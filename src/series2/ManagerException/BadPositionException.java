package series2.ManagerException;

public class BadPositionException extends Exception {
    private int wrongNb;
    private int activitesNb;

    public BadPositionException(String message, int wrongNb, int activitesNb) {
        super(message);
        setWrongNb(wrongNb);
        setActivitesNb(activitesNb);
    }

    public void setWrongNb(int wrongNb) {
        this.wrongNb = wrongNb;
    }

    public void setActivitesNb(int activitesNb) {
        this.activitesNb = activitesNb;
    }

    public int getActivitesNb() {
        return activitesNb;
    }

    public int getWrongNb() {
        return wrongNb;
    }
}
