public class Song extends Item {
    private int releaseYear;
    private String artist;

    public Song() {

    }

    public Song(int releaseYear, int rating, String artist) {
        this.releaseYear = releaseYear;
        this.artist = artist;
    }

    public Song(String name, String path, int rating, int id, int releaseYear, String artist) {
        super(name, path, rating, id);
        this.releaseYear = releaseYear;
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
