public class Image extends Item {
    private String source;

    public Image() {

    }

    public Image(String source) {
        this.source = source;
    }

    public Image(String name, String path, int rating, int id, String source) {
        super(name, path, rating, id);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
