public class Book {
    // Declare private variables.
    private String title;
    private int numPages;
    private int pubYear;

    // Class constructor
    public Book(String bookTitle, int bookPages, int bookPubYear) {
        this.title = bookTitle;
        this.numPages = bookPages;
        this.pubYear = bookPubYear;
    }

    // Getters
    public String getTitle() {
        return this.title;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public int getPubYear() {
        return this.pubYear;
    }

    @Override
    public String toString() {
        return (this.getTitle() + ", " + this.getNumPages() + " pages, " + this.getPubYear());
    }

}
