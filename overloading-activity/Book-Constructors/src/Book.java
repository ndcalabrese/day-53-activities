public class Book {
    // Declare private variables.
    private String title;
    private int numPages;
    private int pubYear;

    // Class constructors
    public Book(String bookTitle, int bookPages, int bookPubYear) {
        this.title = bookTitle;
        this.numPages = bookPages;
        this.pubYear = bookPubYear;
    }

    public Book(String bookTitle, int bookPages) {
        this.title = bookTitle;
        this.numPages = bookPages;
    }

    public Book(int bookPages, int bookPubYear) {
        this.numPages = bookPages;
        this.pubYear = bookPubYear;
    }

    public Book(String bookTitle) {
        this.title = bookTitle;
    }

    public Book(int bookPages) {
        this.numPages = bookPages;
    }

    public Book() {

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

    // Setters
    public void setTitle(String bookTitle) {
        this.title = bookTitle;
    }

    public void setNumPages(int bookPages) {
        this.numPages = bookPages;
    }

    public void setPubYear(int bookPubYear) {
        this.pubYear = bookPubYear;
    }

    @Override
    public String toString() {
        return (this.getTitle() + ", " + this.getNumPages() + " pages, " + this.getPubYear());
    }

}
