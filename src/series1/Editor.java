package series1;

public class Editor {

    private final String name;
    private final City city;

    public Editor(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "les éditions " + name;
    }
}
