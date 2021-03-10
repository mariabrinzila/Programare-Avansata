import java.util.*;

public class TravelPlan {
    /**
     * vom avea un oras si pentru locatiile din acel oras, preferintele turistului
     * preferences.get(i) -> [1, c.size()] in functie de preferinta (1 -> cea mai preferata, 10 -> cea mai putin preferata)
     */
    City c;
    List<Integer> preferences = new ArrayList<>();

    public TravelPlan(City c, List<Integer> preferences) {
        this.c = c;
        this.preferences = preferences;
    }

    public City getC() {
        return c;
    }

    public void setC(City c) {
        this.c = c;
    }

    public List<Integer> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Integer> preferences) {
        this.preferences = preferences;
    }
}
