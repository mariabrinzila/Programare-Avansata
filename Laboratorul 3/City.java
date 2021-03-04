import java.util.*;

public class City extends Location implements Classifiable {
    private int rank;
    private List<Location> locatii = new ArrayList<>();

    public City(int rank, List<Location> locatii) {
        this.rank = rank;
        this.locatii = locatii;
    }

    public City(String name, String description, int rank, List<Location> locatii) {
        super(name, description);
        this.rank = rank;
        this.locatii = locatii;
    }

    public void addLocation(Location locatie) {
        locatii.add(locatie);
    }

    public void setLocatii(List<Location> locatii) {
        this.locatii = locatii;
    }

    public List<Location> getLocatii() {
        return locatii;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "City{" +
                "rank=" + rank +
                ", locatii=" + locatii +
                '}';
    }
}
