import java.util.*;

public abstract class Location implements Comparable<Location> {
    private String name;
    private String description;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location() {
    }

    ;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
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
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
