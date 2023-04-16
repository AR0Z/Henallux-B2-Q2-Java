package series1;

public class City {

    private final String name;
    private int inhabitantsNb;

    public City(String name, int inhabitantsNb) {
        this.name = name;
        setInhabitantsNb(inhabitantsNb);
    }

    public int getInhabitantsNb() {
        return inhabitantsNb;
    }

    public void setInhabitantsNb(int inhabitantsNb) {
        if (inhabitantsNb < 0)
            this.inhabitantsNb = 0;
        else
            this.inhabitantsNb = inhabitantsNb;
    }

}
