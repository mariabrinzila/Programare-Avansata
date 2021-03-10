import java.util.*;
import java.time.LocalTime;

public class City extends Location implements Classifiable {
    private int rank;
    private List<Location> locatii = new ArrayList<>();

    public City() {

    }

    public City(int rank, List<Location> locatii) {
        this.rank = rank;
        this.locatii = locatii;
    }

    public City(String name, String description, int rank, List<Location> locatii, int index) {
        super(name, description, index);
        this.rank = rank;
        this.locatii = locatii;
    }

    public List<Location> locationType() {
        List<Location> onlyVisitable = new ArrayList<>();
        int i, nr, j;
        boolean visitable;
        boolean payable;

        for (i = 0; i < locatii.size(); i++) {
            //vedem cate interfete implementeaza clasa obiectului curent
            nr = locatii.get(i).getClass().getInterfaces().length;
            visitable = false;
            payable = false;

            for (j = 0; j < nr; j++) {
                if (locatii.get(i).getClass().getInterfaces()[j].getSimpleName() == "Visitable")
                    visitable = true;
                if (locatii.get(i).getClass().getInterfaces()[j].getSimpleName() == "Payable")
                    payable = true;
            }

            if (visitable == true && payable == false)
                onlyVisitable.add(locatii.get(i));
        }

        //sortam locatiile crescator dupa opening hour
        //folosim clasa Comparator -> functia compare
        Collections.sort(onlyVisitable, this::compare);
        return onlyVisitable;
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
