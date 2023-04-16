package series1;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        City city = new City("Arlon", 10);
        Editor editor = new Editor("test", city);
        ScientificBook scienceBook = new ScientificBook("scienceBook", Year.of(2020), editor, 10, 10, 10, 10);
        System.out.println(scienceBook);

        System.out.println(scienceBook.getEditor());
        System.out.println(scienceBook.getEditor().getCity().getInhabitantsNb());


        Author author = new Author("Germain", "Duchêne");

        author.addBook(scienceBook);

        Book book = new Book("book", Year.of(2020), editor, 10, 10, 10);

        author.addBook(book);

        System.out.println(author.booksListing());
        System.out.println(author.countAllBooksPages());
        scienceBook.setPrefacePagesNb(11);
        System.out.println(author.countAllBooksPages());

        System.out.println(ScientificBook.pagesNbAverage());
    }
}
