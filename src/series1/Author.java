package series1;

public class Author {
    public final int NB_MAX_BOOKS = 24;
    private final String firstname;
    private final String lastname;
    private final Book[] books;

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        books = new Book[NB_MAX_BOOKS];
    }

    private int booksNb() {
        int booksNb = 0;

        for (int i = 0; i < NB_MAX_BOOKS; i++) {
            if (books[i] != null) {
                booksNb++;
            }
        }

        return booksNb;
    }

    public void addBook(Book book) {
        int booksNb = booksNb();
        if (booksNb < NB_MAX_BOOKS)
            books[booksNb] = book;
    }

    public int countAllBooksPages() {
        int countAllBooksPages = 0;
        for (Book book : books) {
            if (book != null)
                countAllBooksPages += book.pagesCounting();
        }

        return countAllBooksPages;
    }

    public String booksListing() {
        StringBuilder out = new StringBuilder("Listing des livres :");
        int booksNb = booksNb();

        for (int i = 0; i < booksNb; i++) {
            out.append("\nprésentation du ");
            out.append(i == 0 ? "premier" : (i == booksNb ? "dernier" : "du " + i + "ème"));
            out.append(" livre écrit par l'auteur\n");
            out.append(books[i]);
        }

        return out.toString();
    }


}
