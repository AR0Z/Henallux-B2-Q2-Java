package series1;

import java.time.Year;

public class Book extends Publication implements Paging {

    private int tableOfContentPagesNb;
    private int prefacePagesNb;
    private int contentPagesNb;

    public Book(String title, Year editionYear, Editor editor, int tableOfContentPagesNb, int prefacePagesNb, int contentPagesNb) {
        super(title, editionYear, editor);
        setTableOfContentPagesNb(tableOfContentPagesNb);
        setPrefacePagesNb(prefacePagesNb);
        setContentPagesNb(contentPagesNb);
    }

    public void setTableOfContentPagesNb(int tableOfContentPagesNb) {
        if (tableOfContentPagesNb < 0)
            this.tableOfContentPagesNb = 0;
        else
            this.tableOfContentPagesNb = tableOfContentPagesNb;
    }

    public void setPrefacePagesNb(int prefacePagesNb) {
        if (prefacePagesNb < 0)
            this.prefacePagesNb = 0;
        else
            this.prefacePagesNb = prefacePagesNb;
    }

    public void setContentPagesNb(int contentPagesNb) {
        if (contentPagesNb < 0)
            this.contentPagesNb = 0;
        else
            this.contentPagesNb = contentPagesNb;
    }

    public int pagesCounting() {
        return tableOfContentPagesNb + prefacePagesNb + contentPagesNb;
    }

    @Override
    public String type() {
        return "Le livre";
    }

    @Override
    public String toString() {
        return super.toString() + "\ncompte " + pagesCounting() + " pages et est intitulé " + super.getTitle();
    }
}
