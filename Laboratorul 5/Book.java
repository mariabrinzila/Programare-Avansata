public class Book extends Item {
    private String author;
    private int year;

    public Book() {

    }

    public Book(String author, int year) {
        this.author = author;
        this.year = year;
    }

    public Book(String name, String path, int rating, int id, String author, int year) {
        super(name, path, rating, id);
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
