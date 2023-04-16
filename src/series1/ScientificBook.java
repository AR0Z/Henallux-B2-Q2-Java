package series1;

import java.time.Year;

public class ScientificBook extends Book {
    private int appendixPagesNb;
    private static int AllBookPagesNb = 0;
    private static int booksNb = 0;

    public ScientificBook(String title, Year editionYear, Editor editor, int tableOfContentPagesNb, int prefacePagesNb, int contentPagesNb, int appendixPagesNb) {
        super(title, editionYear, editor, tableOfContentPagesNb, prefacePagesNb, contentPagesNb);
        this.appendixPagesNb = appendixPagesNb;

        AllBookPagesNb = pagesCounting();
        booksNb++;
    }

    public void setAppendixPagesNb(int appendixPagesNb) {
        if (appendixPagesNb < 0)
            this.appendixPagesNb = 0;
        else
            this.appendixPagesNb = appendixPagesNb;
    }

    public static double pagesNbAverage() {
        return AllBookPagesNb / booksNb;
    }

    @Override
    public String type() {
        return "L'ouvrage scientifique";
    }

    public int pagesCounting() {
        return super.pagesCounting() + appendixPagesNb;
    }
}
