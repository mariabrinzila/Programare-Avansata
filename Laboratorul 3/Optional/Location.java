import java.time.LocalTime;
import java.util.*;

public abstract class Location implements Comparable<Location>, Comparator<Location> {
    private String name;
    private int indexObiect;
    private String description;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location() {
    }

    ;

    public Location(String name, String description, int indexObiect) {
        this.name = name;
        this.description = description;
        this.indexObiect = indexObiect;
    }

    public int getIndexObiect() {
        return indexObiect;
    }

    public void setIndexObiect(int indexObiect) {
        this.indexObiect = indexObiect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location locatie, int val) {
        cost.put(locatie, val);
    }

    @Override
    public int compareTo(Location other) {
        if (this.name != null)
            return this.name.compareTo(other.name);
        return 0;
    }

    @Override
    public int compare(Location o1, Location o2) {
        //doar locatiile Church sunt visitable si nu payable
        //cast la Church pentru a avea acces la ora deschiderii
        return ((Church) o1).getOpening().compareTo(((Church) o2).getOpening());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
