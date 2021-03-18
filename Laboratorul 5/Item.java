import java.io.Serializable;

public abstract class Item implements Serializable {
    private int itemId;
    private String name;
    private String path;
    private int rating;

    public Item() {

    }

    ;

    public Item(String name, String path, int rating, int id) {
        this.name = name;
        this.path = path;
        this.rating = rating;
        this.itemId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
