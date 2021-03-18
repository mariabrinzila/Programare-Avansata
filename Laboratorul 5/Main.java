import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Song s1 = new Song();
        s1.setName("Call out my name");
        s1.setArtist("The Weeknd");
        s1.setReleaseYear(2019);
        s1.setItemId(1);
        s1.setPath("E:/Pregatire/Song1.mp3");

        Image i1 = new Image();
        i1.setItemId(2);
        i1.setName("Image 1");
        i1.setSource("Pinterest");
        i1.setPath("E:/ASII/youtube.png");

        Book b1 = new Book("Harry Potter 1", "E:/TW/Book.pdf", 10, 5, "J. K. Rowling", 1990);

        Catalog c = new Catalog();
        c.add(s1);
        c.add(i1);
        c.add(b1);
        c.list();
        c.setPath("E:/Catalog/catalog.ser");

        CatalogCommand.play(i1);
        CatalogCommand.play(s1);
        CatalogCommand.play(b1);
        CatalogCommand.save(c);
        Catalog loadResult = CatalogCommand.load(c.getPath());
        System.out.println(loadResult.getNrElemList());
    }
}