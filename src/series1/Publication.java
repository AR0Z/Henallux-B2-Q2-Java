package series1;

import java.time.Year;

public class Publication {

    private final String title;
    private Year editionYear;
    private final Editor editor;

    public Publication(String title, Year editionYear, Editor editor) {
        this.title = title;
        this.editionYear = editionYear;
        this.editor = editor;
    }

    public void setEditionYear(Year editionYear) {
        if (editionYear.isAfter(Year.now()))
            this.editionYear = Year.now();
        else
            this.editionYear = editionYear;
    }

    public String getTitle() {
        return title;
    }

    public Editor getEditor() {
        return editor;
    }

    public String type() {
        return "L'ouvrage";
    }

    @Override
    public String toString() {
        return type() + " édité en " + editionYear + " par " + editor;
    }
}
